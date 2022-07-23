package com.psj.fmmall.dao;

import com.psj.fmmall.entity.ProductImg;
import com.psj.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImgMapper extends GeneralDAO<ProductImg> {

    // 根据商品Id查询商品图片信息
    public List<ProductImg> selectProductImgByProductId(int productId);

}