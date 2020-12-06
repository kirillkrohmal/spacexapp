package com.spacexapp.controller;

import com.spacexapp.model.Launch;
import com.spacexapp.model.Requests;
import com.spacexapp.service.SpacexServiceImpl;
import com.spacexapp.utils.Launches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaunchController {
    private final Launches launches;
    private SpacexServiceImpl spacexService;

    @Autowired
    public LaunchController(Launches launches, SpacexServiceImpl spacexService) {
        this.launches = launches;
        this.spacexService = spacexService;
    }

    @GetMapping("launches/{id}")
    public List<Launch> getLaunchesByRocket(@PathVariable(value = "id") String id) {
        //spacexService.saveRequest(requests);
        return launches.getByRocketId(id);
    }
}
