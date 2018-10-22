package com.anonymous.diagsystem.Dao;

import com.anonymous.diagsystem.Entities.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SymptomDao extends JpaRepository<Symptoms, Long> {

    Optional<Symptoms> findBySymptom(String newkey);
}
