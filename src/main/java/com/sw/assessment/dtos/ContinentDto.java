package com.sw.assessment.dtos;

import com.sw.assessment.entities.Continent;
import com.sw.assessment.entities.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
public class ContinentDto {

    @Getter
    @Setter
    String name;

    public static ContinentDto fromEntity(Continent continent){
        return ContinentDto.builder()
                .name(continent.getName())
                .build();
    }
}
