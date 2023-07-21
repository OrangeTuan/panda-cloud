package com.example.feignclient.api;

import com.example.feignclient.api.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "feign-client", fallback = HelloServiceFallback.class, configuration = FullLogConfiguration.class)
public interface IHelloService {

    @GetMapping("/test")
    String hello();

}
