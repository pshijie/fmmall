package com.psj.fmmall.general;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author psj
 * @date 2022/7/18 23:55
 * @File: GeneralDAO.java
 * @Software: IntelliJ IDEA
 */
// 简化代码，其他接口只需要实现GeneralDAO接口即可
public interface GeneralDAO<T> extends Mapper<T>, MySqlMapper<T> {
}
