package com.psj.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;


/**
 * 1.Product类没有图片属性，所以创建ProductVO类(比原来的Category多了imgs属性而已)
 * 2.下面属性上的注解可以删除，因为下面属性不是从数据库表中直接获取
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductVO {

    private String productId;
    private String productName;
    private Integer categoryId;
    private Integer rootCategoryId;
    private Integer soldNum;
    private Integer productStatus;
    private Date createTime;
    private Date updateTime;
    private String content;

    // 每个商品的图片列表
    private List<ProductImg> imgs;

}