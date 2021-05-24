package com.wb.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName: ResponseCode
 * @Description: 响应状态码
 * @Author: wangb
 * @Date: 2021/5/24 21:33
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {

    SUCCESS(200, "调用方法成功"),
    FAIL(500, "调用方法失败"),
    NOT_FOUND_METHOD(501, "未找到指定方法"),
    NOT_FOUND_CLASS(502, "未找到指定类");

    private final int code;
    private final String message;
}
