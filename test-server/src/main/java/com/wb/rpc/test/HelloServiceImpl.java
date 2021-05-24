package com.wb.rpc.test;

import com.wb.rpc.HelloObject;
import com.wb.rpc.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: HelloServiceImpl
 * @Description: 公共接口的具体实现类
 * @Author: wangb
 * @Date: 2021/5/24 21:21
 */
public class HelloServiceImpl implements HelloService {

    /**
     * 使用 HelloServiceImpl 初始化日志对象，方便在日志输出的时候，可以打印出日志信息所属的类。
     */
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject object) {
        // 使用 {} 可以直接将 getMessage() 内容输出
        logger.info("接收到: {}", object.getMessage());
        return "这是调用的返回值: id=" + object.getId();
    }
}