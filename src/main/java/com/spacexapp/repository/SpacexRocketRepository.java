package com.spacexapp.repository;


import com.spacexapp.model.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpacexRocketRepository extends JpaRepository<Rocket, Integer> {

}
