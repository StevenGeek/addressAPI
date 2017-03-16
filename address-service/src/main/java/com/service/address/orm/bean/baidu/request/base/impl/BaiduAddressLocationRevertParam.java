package com.service.address.orm.bean.baidu.request.base.impl;

import com.service.address.orm.bean.baidu.LocationBean;
import com.service.address.orm.bean.baidu.request.base.BaiDuAddressBaseReqParam;

/**
 * 百度地图api地址逆解析询请求参数
 * 
 * @date 2017年3月15日
 * @author steven
 */
public class BaiduAddressLocationRevertParam extends BaiDuAddressBaseReqParam {

    /**
     * 坐标的类型，目前支持的坐标类型包括：bd09ll（百度经纬度坐标）、bd09mc（百度米制坐标）、gcj02ll（国测局经纬度坐标）、wgs84ll（ GPS经纬度） bd09ll 百度经纬度坐标
     */
    private String coordtype;
    /**
     * 根据经纬度坐标获取地址
     */
    private LocationBean location;
    /**
     * 是否显示指定位置周边的poi，0为不显示，1为显示。当值为1时，默认显示周边1000米内的poi。
     */
    private String pois;
    /**
     * poi召回半径，允许设置区间为0-1000米，超过1000米按1000米召回。
     */
    private String radius;

    public String getCoordtype() {
        return coordtype;
    }

    public void setCoordtype(String coordtype) {
        this.coordtype = coordtype;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public String getPois() {
        return pois;
    }

    public void setPois(String pois) {
        this.pois = pois;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }
}
