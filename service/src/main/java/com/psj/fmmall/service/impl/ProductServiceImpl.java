package com.psj.fmmall.service.impl;

import com.psj.fmmall.dao.ProductMapper;
import com.psj.fmmall.entity.ProductVO;
import com.psj.fmmall.service.ProductService;
import com.psj.fmmall.vo.ResStatus;
import com.psj.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author psj
 * @date 2022/7/23 23:39
 * @File: ProductServiceImpl.java
 * @Software: IntelliJ IDEA
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    // 获取推荐商品
    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", productVOS);
        return resultVO;
    }
}
