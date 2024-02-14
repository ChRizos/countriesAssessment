package com.sw.assessment.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Region {

    @Getter
    @Setter
    int id;

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    int continent_id;

}
