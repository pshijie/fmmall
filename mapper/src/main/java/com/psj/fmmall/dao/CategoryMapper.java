package com.psj.fmmall.dao;

import com.psj.fmmall.entity.Category;
import com.psj.fmmall.entity.CategoryVO;
import com.psj.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends GeneralDAO<Category> {

    // 查询所有类别(包括一/二/三级):使用连接查询
    public List<CategoryVO> selectAllCategories();

    // 查询所有类别(包括一/二/三级):使用子查询(根据parentId查询子分类)
    public List<CategoryVO> selectAllCategories2(int parentId);

}