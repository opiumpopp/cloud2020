package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.mapper.OrderMapper;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author opiumpopp
 * @create 2021-01-16
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        // 1.新建订单
        log.info("------>开始新建订单");
        orderMapper.create(order);
        // 2.扣减库存
        log.info("------>订单微服务开始调用库存微服务，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------>订单微服务调用库存微服务结束");
        // 3.扣减账户
        log.info("------>订单微服务调用账户微服务，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------>订单微服务调用账户微服务结束");
        // 4.修改订单状态，从0变1，1代表已经完成
        log.info("------>修改订单状态开始");
        orderMapper.update(order.getUserId(), 0);
        log.info("------>修改订单状态结束");
        log.info("------>下订单结束了，哈哈O(∩_∩)O");
    }

}