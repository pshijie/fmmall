package com.psj.fmmall;

import com.psj.fmmall.dao.CategoryMapper;
import com.psj.fmmall.dao.ProductMapper;
import com.psj.fmmall.entity.CategoryVO;
import com.psj.fmmall.entity.ProductVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author psj
 * @date 2022/7/23 11:57
 * @File: ApiApplicationTest.java
 * @Software: IntelliJ IDEA
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ApiApplicationTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testCategory() {
//        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories2(0);
        for (CategoryVO c1 : categoryVOS) {
            System.out.println(c1);
            for (CategoryVO c2 : c1.getCategories()) {
                System.out.println("\t" + c2);
                for (CategoryVO c3 : c2.getCategories()) {
                    System.out.println("\t\t" + c3);
                }
            }
        }
    }

    @Test
    public void testRecommend() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        for (ProductVO productVO : productVOS) {
            System.out.println(productVO);
        }
    }
}
