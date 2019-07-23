package com.company.project.project.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Setter
@Getter
@ToString
@ApiModel
public class Result<T> {
    @ApiModelProperty("状态码")
    private int code;
    @ApiModelProperty("返回消息")
    private String message;
    @ApiModelProperty("返回数据")
    private T data;

    /**
     * 成功结果
     *
     * @param message
     * @return
     */
    public static Result<String> success(String message) {
        return success(message, "");
    }

    /**
     * 成功结果
     *
     * @return
     */
    public static Result<String> success() {
        return success("", "");
    }

    /**
     * 成功结果
     *
     * @param data
     * @return
     */
    public static <T> Result<T> success(T data) {
        return success("", data);
    }

    /**
     * 成功结果
     *
     * @param message
     * @param data
     * @return
     */
    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(ResultCode.SUCCESS.code());
        result.setMessage(StringUtils.isEmpty(message) ? ResultCode.SUCCESS.message() : message);

        return result;
    }

    /**
     * 失败结果
     *
     * @param message
     * @return
     */
    public static Result fail(String message) {
        return fail(ResultCode.FAIL.code(), message);
    }


    /**
     * 失败结果
     *
     * @param code
     * @param message
     * @return
     */
    public static Result fail(int code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
