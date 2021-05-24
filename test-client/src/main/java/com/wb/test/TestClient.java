package com.wb.test;

import com.wb.rpc.HelloObject;
import com.wb.rpc.HelloService;
import com.wb.rpc.transport.RpcClientProxy;

/**
 * @ClassName: TestClient
 * @Description: 测试用客户端
 * @Author: wangb
 * @Date: 2021/5/24 22:19
 */
public class TestClient {

    public static void main(String[] args) {

        // 接口与代理对象之间的中介对象
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        // 创建代理对象
        HelloService helloService = proxy.getProxy(HelloService.class);
        // 接口方法的参数对象
        HelloObject object = new HelloObject(12, "This is test message");
        // 由动态代理可知，代理对象调用 hello() 实际执行 invoke()
        String res = helloService.hello(object);
        System.out.println(res);
    }

}