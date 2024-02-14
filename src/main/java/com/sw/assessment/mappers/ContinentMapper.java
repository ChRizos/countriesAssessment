package com.sw.assessment.mappers;

import com.sw.assessment.entities.Continent;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ContinentMapper {
    @Select("SELECT * from continents where name = #{name}")
    Continent findContinentByName(@Param("name") String name);

    @Select("SELECT * from continents")
    List<Continent> findAll();
}
