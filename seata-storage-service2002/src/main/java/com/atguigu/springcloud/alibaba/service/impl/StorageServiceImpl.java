package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.mapper.StorageMapper;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author opiumpopp
 * @create 2021-01-16
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------>storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------>storage-service中扣减库存结束");
    }

}