package com.zfsoft.zftal.mapper;

import com.zfsoft.zftal.BaseMapper;
import com.zfsoft.zftal.model.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/** 如果你想使用注解的方式来操作数据库，那么可以这样来定义 mapper
 * 如果是Oracle，需要表名大写，字段大写，或者是加上引号
 * @author Administrator*/
@Repository("city2Mapper")
public interface City2Mapper extends BaseMapper<City> {

}