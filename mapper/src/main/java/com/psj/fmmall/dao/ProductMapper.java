package com.psj.fmmall.dao;

import com.psj.fmmall.entity.Product;
import com.psj.fmmall.entity.ProductVO;
import com.psj.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends GeneralDAO<Product> {

    // 商品推荐
    public List<ProductVO> selectRecommendProducts();

}