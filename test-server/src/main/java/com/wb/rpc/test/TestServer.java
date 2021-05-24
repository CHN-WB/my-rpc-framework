package com.wb.rpc.test;

import com.wb.rpc.HelloService;
import com.wb.rpc.transport.RpcServer;

/**
 * @ClassName: TestServer
 * @Description: 测试用服务端
 * @Author: wangb
 * @Date: 2021/5/24 22:20
 */
public class TestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        // 注册 HelloServiceImpl 服务
        rpcServer.register(helloService, 9000);
    }

}