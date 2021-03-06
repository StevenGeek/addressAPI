package com.service.address.business;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.service.address.orm.bean.CityBean;
import com.service.web.exception.InfoException;
import com.service.web.exception.ParameterException;

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
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ParameterException
     */
    List<CityBean> queryNextCityList(String p_parentId, String p_grade) throws InstantiationException, IllegalAccessException, ParameterException;

    /**
     * 根据城市编号查询城市信息
     * 
     * @date 2017年3月14日
     * @author steven
     * @param p_cityId 城市编号
     * @return 城市信息
     */
    CityBean queryCity(String p_cityId);

    /**
     * 模糊地址搜索城市信息
     * 
     * @date 2017年3月15日
     * @author steven
     * @param p_address
     * @return
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws ParameterException
     * @throws InfoException
     */
    CityBean fuzzyQueryCityInfo(String p_address) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, IOException, ParameterException, InfoException;

    /**
     * 
     * 根据城市查出所有上级城市
     * 
     * @date 2017年3月16日
     * @author steven
     * @param id 城市编码
     * @return 城市业务类
     */
    CityBean queryCompleteCityInfo(CityBean city);
}
