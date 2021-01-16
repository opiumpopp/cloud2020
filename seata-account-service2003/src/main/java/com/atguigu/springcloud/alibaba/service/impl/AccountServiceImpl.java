package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.mapper.AccountMapper;
import com.atguigu.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author opiumpopp
 * @create 2021-01-16
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------>account-service中扣减账户余额开始");
        // 模拟超时异常，全局事务回滚
        try {
        	TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        accountMapper.decrease(userId, money);
        log.info("------>account-service中扣减账户余额结束");
    }

}