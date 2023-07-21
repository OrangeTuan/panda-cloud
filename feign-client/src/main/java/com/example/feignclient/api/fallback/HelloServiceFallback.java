package com.example.feignclient.api.fallback;

import com.example.feignclient.api.IHelloService;

/**
 *  Fegin配置服务降级的方法
 */
public class HelloServiceFallback implements IHelloService {

    @Override
    public String hello() {
        return "error";
    }

}
