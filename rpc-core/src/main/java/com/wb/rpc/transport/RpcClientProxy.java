package com.wb.rpc.transport;

import com.wb.rpc.entity.RpcRequest;
import com.wb.rpc.entity.RpcResponse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: RpcClientProxy
 * @Description: 客户端动态代理对象
 * @Author: wangb
 * @Date: 2021/5/24 21:41
 */
public class RpcClientProxy implements InvocationHandler {

    private String host;
    private int port;

    // 传递 host 和 port 来指明服务端的位置
    public RpcClientProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    // 抑制编译器产生警告信息
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 向服务端发送的请求对象
        RpcRequest rpcRequest = RpcRequest.builder()
                .interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameters(args)
                .paramTypes(method.getParameterTypes())
                .build();
        // 进行远程调用的客户端
        RpcClient rpcClient = new RpcClient();
        return ((RpcResponse) rpcClient.sendRequest(rpcRequest, host, port)).getData();
    }
}