package com.spacexapp.controller;

import com.spacexapp.model.Requests;
import com.spacexapp.model.Rockets;
import com.spacexapp.service.SpacexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    public List<String> getRockets() {
        String path = "rockets";
        Timestamp ts = new Timestamp(new Date().getTime());

        String data = "";
        for (String s : rockets.getRockets()) data += s + " ";

        data = data.trim();

        Requests requests = new Requests(path, data, ts);
        spacexService.saveRequest(requests);
        return rockets.getRockets();
    }
}
