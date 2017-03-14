package com.service.address.business;

import java.util.List;

import com.service.address.orm.bean.CityBean;

/**
 * 地址库业务层
 * 
 * @date 2017年3月14日
 * @author steven
 */
public interface IAddressBusiness {
    /**
     * 查询下级城市列表
     * 
     * @date 2017年3月14日
     * @author steven
     * @param p_parentId 上级节点
     * @return 下级城市列表
     */
    List<CityBean> queryNextCityList(String p_parentId);

    /**
     * 根据城市编号查询城市信息
     * 
     * @date 2017年3月14日
     * @author steven
     * @param p_cityId 城市编号
     * @return 城市信息
     */
    CityBean queryCity(String p_cityId);
}