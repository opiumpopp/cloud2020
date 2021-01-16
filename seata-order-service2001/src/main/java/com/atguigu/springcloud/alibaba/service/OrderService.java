package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * @author opiumpopp
 * @create 2021-01-16
 */
public interface OrderService {

    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

}