package com.spacexapp.repository;

import com.spacexapp.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpacexRepository extends JpaRepository<Requests, Integer> {

}
