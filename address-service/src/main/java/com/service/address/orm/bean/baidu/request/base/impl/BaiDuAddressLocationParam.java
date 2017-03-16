package com.service.address.orm.bean.baidu.request.base.impl;

import com.service.address.orm.bean.baidu.request.base.BaiDuAddressBaseReqParam;

/**
 * 百度api地址解析参数
 * 
 * @date 2017年3月15日
 * @author steven
 */
public class BaiDuAddressLocationParam extends BaiDuAddressBaseReqParam {
    /**
     * 地址
     */
    // 根据指定地址进行坐标的反定向解析，最多支持100个字节输入。
    //
    // 可以输入三种样式的值，分别是：
    // 1、标准的地址信息，如北京市海淀区上地十街十号
    // 2、名胜古迹、标志性建筑物，如天安门，百度大厦
    // 3、支持“*路与*路交叉口”描述方式，如北一环路和阜阳路的交叉路口
    //
    // 注意：后两种方式并不总是有返回结果，只有当地址库中存在该地址描述时才有返回。
    private String address;
    /**
     * 地址所在的城市名。用于指定上述地址所在的城市，当多个城市都有上述地址时，该参数起到过滤作用。
     */
    private String city;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
