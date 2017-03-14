package com.service.address.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.address.business.IAddressBusiness;
import com.service.address.orm.bean.CityBean;
import com.service.address.orm.dao.CityRepository;

@Service
public class AddressBusiness implements IAddressBusiness {
    /**
     * 城市Dao层注入
     */
    @Autowired
    private CityRepository c_cityRepository;

    @Override
    public List<CityBean> queryNextCityList(String p_parentId) {
        List<CityBean> m_cityBeans = new ArrayList<>();
        BeanUtils.copyProperties(m_cityBeans, c_cityRepository.findByParentId(p_parentId));
        return m_cityBeans;
    }

    @Override
    public CityBean queryCity(String p_cityId) {
        CityBean m_cityBean = new CityBean();
        BeanUtils.copyProperties(m_cityBean, c_cityRepository.findById(p_cityId));
        return m_cityBean;
    }
}
