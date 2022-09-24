package com.example.decathlon.controller;

import com.example.decathlon.entity.Athlete;
import com.example.decathlon.repository.AthleteRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AthleteController {

    @Autowired
    AthleteRepository athleteRepository;

    @GetMapping("athletes")
    public List<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    @GetMapping("athlete/{id}")
    public Athlete getAthlete(@PathVariable Long id) {
        return athleteRepository.findAthleteById(id);
    }

    @PostMapping("add-athlete")
    public List<Athlete> addAthlete(@RequestBody Athlete athlete) {
        athleteRepository.save(athlete);
        return athleteRepository.findAll();
    }

    @PutMapping("athlete/{id}")
    public Athlete updateAthlete(@PathVariable Long id, @RequestBody Athlete athlete) {

        Athlete originalAthlete = athleteRepository.findAthleteById(id);
        originalAthlete.setAge(athlete.getAge());
        originalAthlete.setFirstName(athlete.getFirstName());
        originalAthlete.setLastName(athlete.getLastName());
        originalAthlete.setCountry(athlete.getCountry());
        originalAthlete.setPoints(athlete.getPoints());
        System.out.println("originAthlete ID: " +originalAthlete.getFirstName());
        athleteRepository.save(originalAthlete);

        return originalAthlete;
    }


    @DeleteMapping("athlete/{id}")
    public List<Athlete> deleteAthlete(@PathVariable Long id) {
        athleteRepository.delete(athleteRepository.findAthleteById(id));
        return athleteRepository.findAll();
    }

    @GetMapping("user-points/{id}")
    public String getUserPoints(@PathVariable Long id) {

        return "kasutaja punktid on: ";
    }

}
