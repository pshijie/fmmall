package com.psj.fmmall.service;

import com.psj.fmmall.vo.ResultVO;

/**
 * @author psj
 * @date 2022/7/22 11:55
 * @File: IndexService.java
 * @Software: IntelliJ IDEA
 */
public interface IndexImgService {

    // 查询轮播图信息(status=1且按照seq进行排序的轮播图)
    public ResultVO listIndexImgs();

}
