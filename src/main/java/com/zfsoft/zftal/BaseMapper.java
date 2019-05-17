package com.zfsoft.zftal;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * 统一管理自定义基础mapper
 *
 * @author YS-FYQ-1512
 *
 * @param <T>
 */
public interface BaseMapper<T> extends Mapper<T>, InsertListMapper<T>, MySqlMapper<T> {
//public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T> {
    //FIXME 特别注意，该接口不能被扫描到，否则会出错

}
