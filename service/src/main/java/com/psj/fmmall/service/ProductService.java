package com.psj.fmmall.service;


import com.psj.fmmall.vo.ResultVO;

/**
 * @author psj
 * @date 2022/7/23 23:38
 * @File: ProductService.java
 * @Software: IntelliJ IDEA
 */
public interface ProductService {

    // 获取推荐商品
    public ResultVO listRecommendProducts();

}
