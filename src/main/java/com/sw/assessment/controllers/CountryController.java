package com.sw.assessment.controllers;

import com.sw.assessment.dtos.CountryDto;
import com.sw.assessment.mappers.CountryMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/country")
public class CountryController {

    private CountryMapper countryMapper;

    public CountryController(CountryMapper countryMapper){
        this.countryMapper = countryMapper;
    }

    @GetMapping("/all")
    public List<CountryDto> getAll(){
        return countryMapper.findAll()
                .stream()
                .map(CountryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{name}")
    public CountryDto getCountryByName(@PathVariable("name") String name){
        return CountryDto.fromEntity(countryMapper.findCountryByName(name));
    }
}
