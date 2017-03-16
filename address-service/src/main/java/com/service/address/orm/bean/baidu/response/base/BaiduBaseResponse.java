package com.service.address.orm.bean.baidu.response.base;

/**
 * 百度返回信息基类
 * 
 * @date 2017年3月15日
 * @author steven
 */
public class BaiduBaseResponse<T> {
    /**
     * 状态
     */
    private String status;
    /**
     * 返回结果
     */
    private T result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaiduBaseResponse [status=" + status + ", result=" + result + "]";
    }
}
