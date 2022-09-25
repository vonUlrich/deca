package com.example.decathlon.controller;

import com.example.decathlon.controller.eventModel.Event;
import com.example.decathlon.entity.Athlete;
import com.example.decathlon.repository.AthleteRepository;
import com.example.decathlon.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AthleteController {

    @Autowired
    AthleteRepository athleteRepository;
    @Autowired
    PointsService pointsService;

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

    @PatchMapping("athlete/{id}")
    public Athlete updateAthletePartially(@PathVariable Long id, @RequestBody Athlete athlete) {

        Athlete originalAthlete = athleteRepository.findAthleteById(id);
        originalAthlete.setAge(athlete.getAge());
        originalAthlete.setFirstName(athlete.getFirstName());
        originalAthlete.setLastName(athlete.getLastName());
        originalAthlete.setCountry(athlete.getCountry());
        originalAthlete.setPoints(athlete.getPoints());
        athleteRepository.save(originalAthlete);

        return originalAthlete;
    }

    @DeleteMapping("athlete/{id}")
    public List<Athlete> deleteAthlete(@PathVariable Long id) {
        athleteRepository.delete(athleteRepository.findAthleteById(id));
        return athleteRepository.findAll();
    }

    @GetMapping("athlete-points/{id}")
    public String getAthletePoints(@PathVariable Long id) {
        Integer points = athleteRepository.findAthleteById(id).getPoints();
        return "kasutaja punktid on: " + points;
    }

    @GetMapping("calculate/{result}/{event}")
    public Integer getcalculatePoints(@PathVariable Integer result, @PathVariable String event){
        Event eventEnum =  Event.valueOf(event);
        Integer points = pointsService.calculateEventPoints(result, eventEnum);
        return points;
    }

    @PostMapping("add-athlete-points/{id}/{result}/{event}")
    public Integer addPoints(@PathVariable Long id, @PathVariable Integer result, @PathVariable String event){
        Event eventEnum =  Event.valueOf(event);
        Integer points = pointsService.calculateEventPoints(result, eventEnum);
        Athlete athlete = athleteRepository.findAthleteById(id);
        Integer previousScore = athlete.getPoints();
        Integer newScore = previousScore + points;
        athlete.setPoints(newScore);

        if (athlete.getCompletedEvents().stream().anyMatch(
                e -> e.equals(eventEnum.toString()))){
            System.out.println(eventEnum + "-- on juba olemas");
            throw new RuntimeException("Selline aktiviteet juba olemas");
        }

        //athlete.getCompletedEvents().add(eventEnum.toString());
        athlete.getCompletedEvents().add(eventEnum);
        //athlete.setCompletedEvents(eventEnum.toString());
       /* List<Event> athleteEvents = new ArrayList<>();
        athleteEvents.add(eventEnum);*/

        athleteRepository.save(athlete);

        return newScore;
    }
}



