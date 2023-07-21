package com.example.feignclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaochen
 * @date 2023-06-28 15:16
 */
@RestController
public class HelloController {

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }
}
