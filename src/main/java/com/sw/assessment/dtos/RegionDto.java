package com.sw.assessment.dtos;

import com.sw.assessment.entities.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
public class RegionDto {

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    int continent_id;

    public static RegionDto fromEntity(Region region){
        return RegionDto.builder()
                .name(region.getName())
                .continent_id(region.getContinent_id())
                .build();
    }
}
