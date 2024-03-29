package com.sw.assessment.dtos;

import com.sw.assessment.entities.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@AllArgsConstructor
public class CountryDto {

    @Setter
    @Getter
    String name;

    @Setter
    @Getter
    double area;

    @Setter
    @Getter
    Date nationalDay;

    @Setter
    @Getter
    String countryCode2;

    @Setter
    @Getter
    String countryCode3;

    @Setter
    @Getter
    int regionId;

    public static CountryDto fromEntity(Country country){
        return CountryDto.builder()
                .name(country.getName())
                .area(country.getArea())
                .nationalDay(country.getNational_day())
                .countryCode2(country.getCountry_code2())
                .countryCode3(country.getCountry_code3())
                .build();
    }
}
