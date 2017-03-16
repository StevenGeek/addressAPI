package com.service.address.orm.bean.baidu.response.base.impl;

import java.io.Serializable;

import com.service.address.orm.bean.LocationBean;

/**
 * 百度地址查询结果类
 * 
 * @date 2017年3月15日
 * @author steven
 */
public class BaiDuAddressQueryResult implements Serializable {
    /**
     * 
     * @date 2017年3月15日
     * @author steven
     */
    private static final long serialVersionUID = -2115388258955837844L;
    // /**
    // * 返回结果状态值， 成功返回0
    // *
    // *
    // * 返回码 定义
    // * 0 正常
    // * 1 服务器内部错误
    // * 2 请求参数非法
    // * 3 权限校验失败
    // * 4 配额校验失败
    // * 5 ak不存在或者非法
    // * 101 服务禁用
    // * 102 不通过白名单或者安全码不对
    // * 2xx 无权限
    // * 3xx 配额错误
    // *
    // */
    private Integer status;
    /**
     * 经纬度坐标
     */
    private LocationBean location;
    /**
     * 位置的附加信息，是否精确查找。1为精确查找，即准确打点；0为不精确，即模糊打点。
     */
    private Integer precise;
    /**
     * 可信度，描述打点准确度
     */
    private Integer confidence;
    /**
     * 地址类型
     */
    private String level;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public Integer getPrecise() {
        return precise;
    }

    public void setPrecise(Integer precise) {
        this.precise = precise;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "BaiDuAddressQueryResult [status=" + status + ", location=" + location + ", precise=" + precise + ", confidence=" + confidence + ", level="
                + level + "]";
    }
}
