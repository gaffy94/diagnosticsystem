package com.anonymous.diagsystem.Dao;

import com.anonymous.diagsystem.Entities.DiSyMatrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiSyMatrixDao extends JpaRepository<DiSyMatrix, Long> {

    List<DiSyMatrix> findBySymptomId(Long val);

    List<DiSyMatrix> findBySymptomIdIsIn(List<Long> symptoms);

    List<DiSyMatrix> findByDiseaseId(Long diseaseId);
}
