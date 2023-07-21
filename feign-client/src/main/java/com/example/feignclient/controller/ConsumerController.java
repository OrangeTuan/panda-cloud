package com.example.feignclient.controller;

import com.example.feignclient.api.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaochen
 * @date 2023-06-28 15:23
 */
@RestController
public class ConsumerController {

    @Autowired
    IHelloService helloService;

    @GetMapping("/consumer")
    public String consumer() {
        return "消费端:" + helloService.hello();
    }
}
