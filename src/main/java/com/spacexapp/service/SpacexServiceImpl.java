package com.spacexapp.service;


import com.spacexapp.model.Requests;
import com.spacexapp.repository.SpacexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SpacexServiceImpl implements SpacexService {
    private SpacexRepository spacexRepository;

    @Autowired
    public SpacexServiceImpl(SpacexRepository spacexRepository) {
        this.spacexRepository = spacexRepository;
    }

    @Override
    public void saveRequest(Requests requests) {
        spacexRepository.save(requests);
    }
}
