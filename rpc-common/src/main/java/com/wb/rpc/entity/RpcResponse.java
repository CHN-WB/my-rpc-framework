package com.wb.rpc.entity;

import com.wb.rpc.enumeration.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: RpcResponse
 * @Description: 服务端返回的响应对象
 * @Author: wangb
 * @Date: 2021/5/24 21:27
 */
@Data
public class RpcResponse<T> implements Serializable {

    /**
     * 响应状态码
     */
    private Integer statusCode;

    /**
     * 响应状态码对应的信息
     */
    private String message;

    /**
     * 成功时的响应数据
     */
    private T data;

    /**
     * 成功时服务端返回的对象
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RpcResponse<T> success(T data) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> RpcResponse<T> fail(ResponseCode code) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }

}