package com.spacexapp.service;


import com.spacexapp.model.Requests;
import org.springframework.stereotype.Service;

@Service
public interface SpacexService {
    void saveRequest(Requests requests);

}
