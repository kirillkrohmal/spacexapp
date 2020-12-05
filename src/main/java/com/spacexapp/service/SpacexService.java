package com.spacexapp.service;


import com.spacexapp.model.Launch;
import com.spacexapp.model.Rocket;
import org.springframework.stereotype.Service;

@Service
public interface SpacexService {
    void saveRocket(Rocket rocket);
    void saveLaunches(Launch launch);

    void findById(int id);
}
