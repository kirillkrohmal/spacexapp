package com.spacexapp.service;


import com.spacexapp.model.Launch;
import com.spacexapp.model.Rocket;
import com.spacexapp.repository.SpacexLaunchesRepository;
import com.spacexapp.repository.SpacexRocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpacexServiceImpl implements SpacexService {
    private SpacexRocketRepository spacexRocketRepository;
    private SpacexLaunchesRepository spacexLaunchesRepository;

    @Autowired
    public SpacexServiceImpl(SpacexRocketRepository spacexRepository, SpacexLaunchesRepository spacexLaunchesRepository) {
        this.spacexRocketRepository = spacexRepository;
        this.spacexLaunchesRepository = spacexLaunchesRepository;
    }

    @Override
    public Rocket saveRocket(Rocket rocket) {
        return spacexRocketRepository.save(rocket);
    }

    @Override
    public Launch saveLaunches(Launch launch) {
        return spacexLaunchesRepository.save (launch);
    }
}
