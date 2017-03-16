package com.service.address.orm.bean;

/**
 * 经纬度
 * 
 * @date 2017年3月15日
 * @author steven
 */
public class LocationBean {
    /**
     * 经度值
     */
    private float lat;
    /**
     * 纬度值
     */
    private float lng;

    @Override
    public String toString() {
        return lat + "," + lng;
    }
}
