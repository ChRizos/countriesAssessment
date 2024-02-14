package com.sw.assessment.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
public class Country {

    @Setter
    @Getter
    int country_id;

    @Setter
    @Getter
    String name;

    @Setter
    @Getter
    double area;

    @Setter
    @Getter
    Date national_day;

    @Setter
    @Getter
    String country_code2;

    @Setter
    @Getter
    String country_code3;

    @Setter
    @Getter
    int region_id;

}
