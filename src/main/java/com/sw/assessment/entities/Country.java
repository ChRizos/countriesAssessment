package com.sw.assessment.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Country {

    public Country() {}

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

}
