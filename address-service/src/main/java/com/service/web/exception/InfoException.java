package com.service.web.exception;

public class InfoException extends Exception {
    /**
     * 
     * @date 2017年3月16日
     * @author steven
     */
    private static final long serialVersionUID = 6590655588688737964L;
    private String message;

    public InfoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return "信息错误";
    }

}
