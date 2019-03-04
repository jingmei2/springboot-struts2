package com.zfsoft.zftal.mapper;

import com.zfsoft.zftal.model.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author magi
 * 对于选择使用注解还是使用 xml 的方式，可以灵活选择
 */
//@Mapper
public interface CityMapper {
    @Select("select * from city where id = #{id}")
    // 返回结果实体属性与数据库字段转换
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "state", column = "state"),
            @Result(property = "country", column = "country")
    })
    City findByProvinceId(@Param("id") Long id);

    List<City> findAll();
}