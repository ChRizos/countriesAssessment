package com.sw.assessment.controllers;

import com.sw.assessment.dtos.CountryDto;
import com.sw.assessment.entities.Country;
import com.sw.assessment.mappers.CountryMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/countries")
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
}
