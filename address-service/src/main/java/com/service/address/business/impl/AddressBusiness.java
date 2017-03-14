package com.service.address.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.service.address.business.IAddressBusiness;
import com.service.address.orm.bean.CityBean;
import com.service.address.orm.dao.CityRepository;
import com.service.web.exception.ParameterException;
import com.service.web.util.BeanListUtil;

@Service
public class AddressBusiness implements IAddressBusiness {
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
}
