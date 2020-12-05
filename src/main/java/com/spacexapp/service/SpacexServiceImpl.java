package com.spacexapp.service;


import com.spacexapp.model.Launch;
import com.spacexapp.model.Rocket;
import com.spacexapp.repository.SpacexLaunchesRepository;
import com.spacexapp.repository.SpacexRocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
    public void saveRocket(Rocket rocket) {
        spacexRocketRepository.save(rocket);
    }

    @Override
    public void saveLaunches(Launch launch) {
        spacexLaunchesRepository.save(launch);
    }

    @Override
    public void findById(int id) {
        spacexRocketRepository.findById(id);
    }


}
