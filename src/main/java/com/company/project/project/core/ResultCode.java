package com.company.project.project.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200,"操作成功"),//成功
    FAIL(400, "操作失败"),//失败
    UNAUTHORIZED(401, "认证失败"),//未认证（签名错误）
    NOT_FOUND(404, "接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),//服务器内部错误
    UNKONW(999, "未知异常，请联系客服");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
