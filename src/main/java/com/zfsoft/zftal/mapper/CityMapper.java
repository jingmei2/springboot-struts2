package com.zfsoft.zftal.mapper;

import com.zfsoft.zftal.model.City;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/** 如果你想使用注解的方式来操作数据库，那么可以这样来定义 mapper
 * 如果是Oracle，需要表名大写，字段大写，或者是加上引号
 * @author Administrator*/
//@Mapper
public interface CityMapper {
    @Select("select * from \"city\" where \"id\" = #{id}")
    // 返回结果实体属性与数据库字段转换
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "state", column = "state"),
            @Result(property = "country", column = "country"),
            @Result(property = "date", column = "date")
    })
    City findByProvinceId(@Param("id") Long id);

    /** 查询全部 */
    @Select("select * from \"city\"")
    List<City> findAll();

    /** 创建 */
    @Select("insert into \"city\" values(uuid(), #{name})")
    String createCity(@ModelAttribute City city);

    /** 更新 */
    @Select("update \"city\" set name=#{name} where id=#{id}")
    void updateCity(@ModelAttribute City city);

    /** 删除 */
    @Select("delete from \"city\" where \"id\"=#{id}")
    void deleteCity(String id);
}