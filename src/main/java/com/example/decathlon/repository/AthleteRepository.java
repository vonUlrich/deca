package com.example.decathlon.repository;

import com.example.decathlon.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Athlete findAthleteById(Long id);
}
