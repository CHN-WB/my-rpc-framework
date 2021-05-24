package com.wb.rpc.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: RpcRequest
 * @Description: 客户端发送的请求对象
 * @Author: wangb
 * @Date: 2021/5/24 21:24
 */
@Data
// 使用创建者模式，一次性给所有变量初始赋值
@Builder
public class RpcRequest implements Serializable {

    /**
     * 待调用接口名称
     */
    private String interfaceName;

    /**
     * 待调用方法名称
     */
    private String methodName;

    /**
     * 待调用方法的参数
     */
    private Object[] parameters;

    /**
     * 待调用方法的参数类型
     */
    private Class<?>[] paramTypes;

}