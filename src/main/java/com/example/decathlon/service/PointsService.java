package com.example.decathlon.service;

import com.example.decathlon.controller.eventModel.Event;
import org.springframework.stereotype.Service;


@Service
public class PointsService {

    public int calculateEventPoints(Integer result, Event event ) {
        switch (event) {
            case HundredMetresRun -> {
                Integer attempt = (int)(Math.floor(25.4347 * Math.pow((18 - result), 1.81)));
                return attempt;
            }
            case LongJump -> {
                Integer attempt = (int)(Math.floor(0.14354 * Math.pow((result - 220), 1.4)));
                return attempt;
            }
            case ShotPut -> {
                Integer attempt = (int)(Math.floor(51.39 * Math.pow((result - 1.5), 1.05)));
                return attempt;
            }
            case HighJump -> {
                Integer attempt = (int)(Math.floor(0.8465 * Math.pow((result - 75), 1.42)));
                return attempt;
            }
            case FourHundredMtrs -> {
                Integer attempt = (int)(Math.floor(1.53775 * Math.pow((82 - result), 1.81)));
                return attempt;
            }
            case ElevenHundredMtrsHurdles -> {
                Integer attempt = (int)(Math.floor(5.74352 * Math.pow((28.5 - result), 1.92)));
                return attempt;
            }
            case DiscusThrow -> {
                Integer attempt = (int)(Math.floor(12.91 * Math.pow((result - 4), 1.1)));
                return attempt;
            }
            case PoleVault -> {
                Integer attempt = (int)(Math.floor(0.2797 * Math.pow((result - 100), 1.35)));
                return attempt;
            }
            case JavelinThrow -> {
                Integer attempt = (int)(Math.floor(10.14 * Math.pow((result - 7), 1.08)));
                return attempt;
            }
            case FifteenHundredMtrs -> {
                Integer attempt = (int)(Math.floor(0.03768 * Math.pow((480 - result), 1.85)));
                return attempt;
            }
            default -> {
                return 0;
            }
        }
    }

}
