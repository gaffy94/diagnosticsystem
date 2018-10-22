package com.anonymous.diagsystem.Dao;

import com.anonymous.diagsystem.Entities.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiseaseDao extends JpaRepository<Disease, Long> {
    Optional<Disease> findByDisease(String newvalue);

}
