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
import com.service.web.exception.InfoException;
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
        // 若有父级Id，则查询下级城市列表
        if (!StringUtils.isEmpty(p_parentId)) {
            List<CityBean> m_cityBeans = new ArrayList<>();
            m_cityBeans = BeanListUtil.getList(c_cityRepository.findByParentId(p_parentId), CityBean.class);
            return m_cityBeans;
            // 若无则查询省级列表
        } else if (!StringUtils.isEmpty(p_grade)) {
            return BeanListUtil.getList(c_cityRepository.findByGrade(p_grade), CityBean.class);
        } else {
            throw new ParameterException("when parentId is null, grade is mandatory");
        }
    }

    @Override
    public CityBean queryCity(String p_cityId) {
        CityBean m_cityBean = new CityBean();
        BeanUtils.copyProperties(c_cityRepository.findByCityId(p_cityId), m_cityBean);
        return m_cityBean;
    }

    @Override
    public CityBean fuzzyQueryCityInfo(String p_address) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, IOException, ParameterException, InfoException {
        // 根据地址解析对应经纬度信息
        BaiduBaseResponse<BaiDuAddressQueryResult> resultBean = BaiduApi.fuzzyQueryCity(p_address, c_BaiDuProperties.getAddress2location());
        // 判断查询结果状态，不为0则抛异常
        if (!"0".equals(resultBean.getStatus())) {
            throw new InfoException("查询不到该地址");
        }
        // 逆向解析地址所在区域
        BaiduBaseResponse<BaiDuAddressQueryRevertResult> revertResultBean = BaiduApi.fuzzyRevertQueryCity(resultBean, c_BaiDuProperties.getAddress2location());
        AddressComponent addressComponent = revertResultBean.getResult().getAddressComponent();
        // 根据解析出的区域Id，到地址库查询详细信息
        CityBean cityBean = queryCity(addressComponent.getAbcode());
        // 查询完整的三级地址信息
        CityBean completeAddress = queryCompleteCityInfo(cityBean);
        // 将完整地址信息也返回
        completeAddress.setCompleteAddress(revertResultBean.getResult().getFormatted_address());
        return completeAddress;
    }

    @Override
    public CityBean queryCompleteCityInfo(CityBean city) {
        if (!StringUtils.isEmpty(city.getParentId())) {
            CityBean parentCity = queryCity(city.getParentId());
            parentCity.setNextCity(city);
            return queryCompleteCityInfo(parentCity);
        }
        return city;
    }

}
