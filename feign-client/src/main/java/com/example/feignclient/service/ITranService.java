package com.example.feignclient.service;


/**
 * 分布式事务服务测试
 * @author xiaochen
 * @date 2023-06-29 14:59
 */
public interface ITranService {
    void login(String userName, String pwd);
}
