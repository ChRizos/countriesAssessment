package com.sw.assessment.controllers;

import com.sw.assessment.dtos.ContinentDto;
import com.sw.assessment.mappers.ContinentMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/continent")
public class ContinentController {

    private ContinentMapper continentMapper;

    public ContinentController(ContinentMapper continentMapper){this.continentMapper = continentMapper;}

    @GetMapping("/all")
    public List<ContinentDto> getAll(){
        return continentMapper.findAll()
                .stream()
                .map(ContinentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public ContinentDto findContinentByName(@PathVariable("name") String name){
        return ContinentDto.fromEntity(continentMapper.findContinentByName(name));
    }
}
