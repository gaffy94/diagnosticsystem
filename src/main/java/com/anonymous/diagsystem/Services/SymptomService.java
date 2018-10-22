package com.anonymous.diagsystem.Services;

import com.anonymous.diagsystem.Dao.SymptomDao;
import com.anonymous.diagsystem.Entities.Symptoms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {
@Autowired
    SymptomDao symptomDao;

    public List<Symptoms> getAll() {
        return symptomDao.findAll();
    }
}
