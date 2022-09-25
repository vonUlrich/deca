package com.example.decathlon.controller;

import com.example.decathlon.entity.Athlete;
import com.example.decathlon.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultsController {

    @Autowired
    AthleteRepository athleteRepository;

    @GetMapping("get-top-athletes")
    public List<Athlete> getTopAthletes(){
        List<Athlete> top10Athletes = athleteRepository.findTop10ByOrderByPointsDesc();
        return top10Athletes;
    }

}
