package com.psj.fmmall.dao;

import com.psj.fmmall.entity.Product;
import com.psj.fmmall.entity.ProductVO;
import com.psj.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends GeneralDAO<Product> {

    // 根据商品创建时间推荐前3个商品
    public List<ProductVO> selectRecommendProducts();

    // 根据一级类别id获取该类别销量前6的商品
    public List<ProductVO> selectTop6ByCategory(int cid);
}