package com.example.feignclient.service.impl;

import com.example.feignclient.service.ITranService;
import io.seata.spring.annotation.GlobalTransactional;

/**
 * 分布式事务服务测试
 * @author xiaochen
 * @date 2023-06-29 15:01
 */
public class TranServiceImpl implements ITranService {



    /**
     * 注册加积分
     * @param userName
     * @param pwd
     */
    @Override
    @GlobalTransactional
    public void login(String userName, String pwd) {
    }

}
