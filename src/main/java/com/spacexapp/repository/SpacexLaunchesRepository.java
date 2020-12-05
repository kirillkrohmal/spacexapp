package com.spacexapp.repository;

import com.spacexapp.model.Launch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpacexLaunchesRepository extends JpaRepository<Launch, Integer> {
}
