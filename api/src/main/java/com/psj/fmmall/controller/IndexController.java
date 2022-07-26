package com.psj.fmmall.controller;

import com.psj.fmmall.service.CategoryService;
import com.psj.fmmall.service.IndexImgService;
import com.psj.fmmall.service.ProductService;
import com.psj.fmmall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author psj
 * @date 2022/7/22 11:59
 * @File: IndexController.java
 * @Software: IntelliJ IDEA
 */
@RestController
@CrossOrigin
@RequestMapping("/index")
@Api(value = "提供首页数据显示接口", tags = "首页管理")
public class IndexController {

    @Autowired
    IndexImgService indexImgService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/indeximg")
    @ApiOperation("首页轮播图接口")
    public ResultVO listIndexImgs() {
        return indexImgService.listIndexImgs();
    }

    @GetMapping("/category")
    @ApiOperation("商品分类查询接口")
    public ResultVO listCategory() {
        return categoryService.listCategories();
    }

    @GetMapping("/list-recommends")
    @ApiOperation("新品推荐接口")
    public ResultVO listRecommendProducts() {
        return productService.listRecommendProducts();
    }

    @GetMapping("/category-recommends")
    @ApiOperation("分类推荐接口")
    public ResultVO listRecommendProductsByCategory() {
        return categoryService.listFirstCategories();
    }

}
