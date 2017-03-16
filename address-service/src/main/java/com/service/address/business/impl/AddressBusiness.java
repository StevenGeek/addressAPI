package com.service.address.business.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.service.address.business.IAddressBusiness;
import com.service.address.orm.bean.CityBean;
import com.service.address.orm.bean.baidu.response.base.BaiduBaseResponse;
import com.service.address.orm.bean.baidu.response.base.impl.BaiDuAddressQueryResult;
import com.service.address.orm.bean.baidu.response.base.impl.BaiDuAddressQueryRevertResult;
import com.service.address.orm.bean.baidu.response.base.impl.BaiDuAddressQueryRevertResult.AddressComponent;
import com.service.address.orm.dao.CityRepository;
import com.service.address.properties.BaiDuProperties;
import com.service.web.exception.ParameterException;
import com.service.web.util.BeanListUtil;
import com.service.web.util.baidu.api.BaiduApi;

@Service
public class AddressBusiness implements IAddressBusiness {

    @Autowired
    private BaiDuProperties c_BaiDuProperties;

    /**
     * 城市Dao层注入
     */
    @Autowired
    private CityRepository c_cityRepository;

    @Override
    public List<CityBean> queryNextCityList(String p_parentId, String p_grade) throws InstantiationException, IllegalAccessException, ParameterException {
        if (!StringUtils.isEmpty(p_parentId)) {
            List<CityBean> m_cityBeans = new ArrayList<>();
            m_cityBeans = BeanListUtil.getList(c_cityRepository.findByParentId(p_parentId), CityBean.class);
            return m_cityBeans;
        } else if (!StringUtils.isEmpty(p_grade)) {
            return BeanListUtil.getList(c_cityRepository.findByGrade(p_grade), CityBean.class);
        } else {
            throw new ParameterException("when parentId is null, grade is mandatory");
        }
    }

    @Override
    public CityBean queryCity(String p_cityId) {
        CityBean m_cityBean = new CityBean();
        BeanUtils.copyProperties(c_cityRepository.findById(p_cityId), m_cityBean);
        return m_cityBean;
    }

    @Override
    public CityBean fuzzyQueryCityInfo(String p_address) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, IOException, ParameterException {
        BaiduBaseResponse<BaiDuAddressQueryResult> resultBean = BaiduApi.fuzzyQueryCity(p_address, c_BaiDuProperties.getAk(),
                c_BaiDuProperties.getAddress2location());
        if (!"0".equals(resultBean.getStatus())) {
            throw new ParameterException("aa");
        }
        BaiduBaseResponse<BaiDuAddressQueryRevertResult> revertResultBean = BaiduApi.fuzzyRevertQueryCity(resultBean, c_BaiDuProperties.getAk(),
                c_BaiDuProperties.getAddress2location());
        AddressComponent addressComponent = revertResultBean.getResult().getAddressComponent();
        CityBean cityBean = queryCity(addressComponent.getAbcode());
        return cityBean;
    }

}
