package com.atguigu.springcoud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author opiumpopp
 * @create 2021-01-09
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }

}