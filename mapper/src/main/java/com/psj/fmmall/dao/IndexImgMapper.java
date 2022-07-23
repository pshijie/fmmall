package com.psj.fmmall.dao;

import com.psj.fmmall.entity.IndexImg;
import com.psj.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexImgMapper extends GeneralDAO<IndexImg> {

    // 查询轮播图信息(status=1且按照seq进行排序的轮播图)
    public List<IndexImg> listIndexImgs();
}