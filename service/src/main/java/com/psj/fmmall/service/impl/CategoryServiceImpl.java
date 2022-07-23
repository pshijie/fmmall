package com.psj.fmmall.service.impl;

import com.psj.fmmall.dao.CategoryMapper;
import com.psj.fmmall.entity.CategoryVO;
import com.psj.fmmall.service.CategoryService;
import com.psj.fmmall.vo.ResStatus;
import com.psj.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author psj
 * @date 2022/7/23 12:14
 * @File: CategoryServiceImpl.java
 * @Software: IntelliJ IDEA
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    // 查询所有类别(包括一/二/三级)
    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "success", categoryVOS);
        return resultVO;
    }
}
