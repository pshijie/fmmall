package com.psj.fmmall.service;

import com.psj.fmmall.vo.ResultVO;

/**
 * @author psj
 * @date 2022/7/23 12:13
 * @File: CategoryService.java
 * @Software: IntelliJ IDEA
 */
public interface CategoryService {

    // 查询所有类别(包括一/二/三级)
    public ResultVO listCategories();

}
