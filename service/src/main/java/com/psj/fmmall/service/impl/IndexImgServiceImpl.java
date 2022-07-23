package com.psj.fmmall.service.impl;

import com.psj.fmmall.dao.IndexImgMapper;
import com.psj.fmmall.entity.IndexImg;
import com.psj.fmmall.service.IndexImgService;
import com.psj.fmmall.vo.ResStatus;
import com.psj.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author psj
 * @date 2022/7/22 11:56
 * @File: IndexImgServiceImpl.java
 * @Software: IntelliJ IDEA
 */
@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;

    // 查询轮播图信息(status=1且按照seq进行排序的轮播图)
    @Override
    public ResultVO listIndexImgs() {
        List<IndexImg> indexImgs = indexImgMapper.listIndexImgs();
        if (indexImgs.size() == 0) {
            return new ResultVO(ResStatus.NO, "fail", null);
        } else {
            return new ResultVO(ResStatus.OK, "success", indexImgs);
        }
    }
}
