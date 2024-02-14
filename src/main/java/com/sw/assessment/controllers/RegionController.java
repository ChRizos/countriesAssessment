package com.sw.assessment.controllers;

import com.sw.assessment.dtos.CountryDto;
import com.sw.assessment.dtos.RegionDto;
import com.sw.assessment.mappers.RegionMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/region")
public class RegionController {

    private RegionMapper regionMapper;

    public RegionController(RegionMapper regionMapper){this.regionMapper = regionMapper;}

    @GetMapping("/all")
    public List<RegionDto> getAll(){
        return regionMapper.findAll()
                .stream()
                .map(RegionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public RegionDto getRegionByName(@PathVariable("name") String name){
        return RegionDto.fromEntity(regionMapper.findRegionByName(name));
    }
}
