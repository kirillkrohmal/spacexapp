package com.spacexapp.service;


import com.spacexapp.model.Launch;
import com.spacexapp.model.Rocket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpacexService {
    Rocket saveRocket(Rocket rocket);
    Launch saveLaunches(Launch launch);
}
