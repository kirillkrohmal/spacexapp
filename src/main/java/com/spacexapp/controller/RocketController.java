package com.spacexapp.controller;

import com.spacexapp.model.Requests;
import com.spacexapp.model.Rockets;
import com.spacexapp.service.SpacexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RocketController {
    private final Rockets rockets;
    private SpacexServiceImpl spacexService;

    @Autowired
    public RocketController(Rockets rockets, SpacexServiceImpl spacexService) {
        this.rockets = rockets;
        this.spacexService = spacexService;
    }

    @GetMapping("rockets")
    public List<String> getRockets(Requests requests) {
        spacexService.saveRequest(requests);
        return rockets.getRockets();
    }
}
