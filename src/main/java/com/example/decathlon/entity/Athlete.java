package com.example.decathlon.entity;

import com.example.decathlon.controller.eventModel.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer points;
    private Integer completedEvents; //TODO natuke mõelda siin
    //private Event event;
    private Integer age;
    private String country;
    //private String ssn;  - isikukood, et ei saaks sama isikut panna
}
