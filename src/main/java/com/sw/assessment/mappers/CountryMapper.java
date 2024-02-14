package com.sw.assessment.mappers;

import com.sw.assessment.entities.Country;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.MappedTypes;

import java.util.ArrayList;
import java.util.List;

//@MappedTypes(Country.class)
@Mapper
public interface CountryMapper {
    @Select("SELECT * from countries where name = #{name}")
    Country findCountryByName(@Param("name") String name);

    @Select("SELECT * from countries")
    List<Country> findAll();

    @Select("SELECT * from countries where region_id = (select region_id from regions where name = #{name})")
    List<Country> findCountiesByRegion(@Param("name") String name);

    @Insert("INSERT into countries(name, area, national_day, country_code2, country_code3, region_id) values(#{name}, #{area}, #{national_day}, #{country_code2}, #{country_code3}, #{region_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insert(Country country);

    @Delete("DELETE from countries where name = #{name}")
    void deleteCountryByName(String name);

    @Update("UPDATE countries set country_code2 = #{country_code2} where name = #{name}")
    void updateCountryByName(String name);
}
