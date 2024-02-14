package com.sw.assessment.mappers;

import com.sw.assessment.entities.Region;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegionMapper {

    @Select("SELECT * from regions where name = #{name}")
    Region findRegionByName(@Param("name") String name);

    @Select("SELECT * from regions")
    List<Region> findAll();
}
