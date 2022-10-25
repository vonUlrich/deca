package com.example.decathlon.entity;

import com.example.decathlon.controller.eventModel.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
    private Integer points = 0;
   /* @ElementCollection
    private List<String> completedEvents =new ArrayList<String>();*/
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Event> completedEvents =new ArrayList<Event>();

    //private Event event;
    private Integer age;
    private String country;
    private String image;
    @Column(nullable = false)
    private String ssn; //  - isikukood, et ei saaks sama isikut panna
}
