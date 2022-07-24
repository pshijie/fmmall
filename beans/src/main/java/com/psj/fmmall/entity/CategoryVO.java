package com.psj.fmmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

/**
 * @author psj
 * @date 2022/7/23 11:42
 * @File: CategoryVO.java
 * @Software: IntelliJ IDEA
 */

/**
 * 1.Category类没有存储二级/三级分类的属性以及分类商品的信息，所以创建CategoryVO类
 * 2.属性上的注解可以删除，因为下面属性不是从数据库表中直接获取
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryVO {

    private Integer categoryId;
    private String categoryName;
    private Integer categoryLevel;
    private Integer parentId;
    private String categoryIcon;
    private String categorySlogan;
    private String categoryPic;
    private String categoryBgColor;

    // 实现首页的类别显示(因为一级下有两级,二级下有三级,所以存储的对象是CategoryVO不是Category)
    private List<CategoryVO> categories;
    // 实现首页分类商品推荐(ProductVO类中带有需要的图片)
    private List<ProductVO> products;

}
