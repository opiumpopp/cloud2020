package com.atguigu.springcloud.alibaba.service;

/**
 * @author opiumpopp
 * @create 2021-01-16
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);

}