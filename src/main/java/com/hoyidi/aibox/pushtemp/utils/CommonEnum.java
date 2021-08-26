package com.hoyidi.aibox.pushtemp.utils;

/**
 * @author Boom
 */

public enum CommonEnum implements BaseResultInfoInterface {
    // 数据操作错误定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400", "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),

    /**
     * 账户没有接口的权限
     */
    ACCOUNT_NOT_PERMISSION("203", "账户没有这个功能"),


    /**
     * 未配置key或无效
     */
    APP_KEY_INVALID("402","未配置key或无效"),

    NOT_FOUND("404","未找到该资源!"),

    ACCESS_DENIED("404","未找到该资源!"),

    INTERNAL_SERVER_ERROR("500","服务器内部错误!"),

    SERVER_BUSY("503","服务器正忙，请稍后再试!"),
            ;

    /**
     * 状态码
     */
    private final String resultCode;

    /**
     * 描述
     */
    private final String resultMsg;

    CommonEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }

}
