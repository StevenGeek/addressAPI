package com.service.address.orm.bean.baidu.request.base;

/**
 * 百度地址查询请求参数类
 * 
 * @date 2017年3月15日
 * @author steven
 */
public class BaiDuAddressBaseReqParam {
    /**
     * 输出格式为json或者xml
     */
    private String output;
    /**
     * 可选参数，添加后返回国测局经纬度坐标或百度米制坐标
     */
    private String ret_coordtype;
    /**
     * 用户申请注册的key，自v2开始参数修改为“ak”，之前版本参数为“key”
     */
    private String ak;
    /**
     * 若用户所用ak的校验方式为sn校验时该参数必须。 （sn生成算法）
     */
    private String sn;
    /**
     * 将json格式的返回值通过callback函数返回以实现jsonp功能 ---------callback=showLocation(JavaScript函数名)
     */
    private String callback;

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getRet_coordtype() {
        return ret_coordtype;
    }

    public void setRet_coordtype(String ret_coordtype) {
        this.ret_coordtype = ret_coordtype;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
