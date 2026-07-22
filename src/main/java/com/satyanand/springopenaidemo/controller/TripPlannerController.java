package com.satyanand.springopenaidemo.controller;

import com.satyanand.springopenaidemo.service.TripPlannerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trips")
public class TripPlannerController {

    private final TripPlannerService tripPlannerService;

    public TripPlannerController(TripPlannerService tripPlannerService){
        this.tripPlannerService = tripPlannerService;
    }

    @GetMapping("/plan-trip")
    public String getTripPlans(@RequestParam String message){
        return tripPlannerService.getTripPlans(message);
    }

}
