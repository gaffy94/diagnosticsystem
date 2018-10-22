package com.anonymous.diagsystem.Services;

import com.anonymous.diagsystem.Dao.DiSyMatrixDao;
import com.anonymous.diagsystem.Dao.DiseaseDao;
import com.anonymous.diagsystem.Dao.SymptomDao;
import com.anonymous.diagsystem.Entities.DiSyMatrix;
import com.anonymous.diagsystem.Entities.DiagnosisResult;
import com.anonymous.diagsystem.Entities.Symptoms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MainControllerService {
    @Autowired
    SymptomDao symptomDao;
    @Autowired
    DiseaseDao diseaseDao;
    @Autowired
    DiSyMatrixDao diSyMatrixDao;


    public List<DiagnosisResult> doDiagnosis(List<Long> symptoms) {
        Map<String, List<Symptoms>> map = new HashMap<>();
        //LOOP THROUGH PROVIDED SYMPTOMS
        for(Long sympid : symptoms) {
            // FETCH LIST OF DISEASES EACH SYMPTOM IS RELATED TO
            List<DiSyMatrix> bySymptomId = diSyMatrixDao.findBySymptomId(sympid);
            //LOOP THROUGH EACH FETCHED DISEASE,
            for(DiSyMatrix mat : bySymptomId){
                // FETCH ALL THE SYMPTOMS FOR THAT PARTICULAR DISEASE
                List<DiSyMatrix> bySymptomId1 =   diSyMatrixDao.findByDiseaseId(mat.getDiseaseId());
                // LOOP THROUGH THE OBJECT AND BUILD A DISEASE/SYMPTOM OBJECT
                for(DiSyMatrix mac : bySymptomId1){
                    if(!map.containsKey(mac.getDisease().getDisease())) {
                        List<Symptoms> tempsymp = new ArrayList<>();
                        tempsymp.add(mac.getSymptoms());
                        map.put(mac.getDisease().getDisease(), tempsymp);
                    } else {
                        List<Symptoms> symptoms1 = map.get(mac.getDisease().getDisease());
                        symptoms1.add(mac.getSymptoms());
                        map.put(mac.getDisease().getDisease(), symptoms1);
                    }
                }

            }
        }
//        for (Map.Entry<String, List<Symptoms>> entry : map.entrySet()) {
//            System.out.println("KEY VALUE >>> "+entry.getKey());
//            for(Symptoms tom: entry.getValue()) {
//                System.out.println("------------------LIST VALUE  >>>>>> "+ tom.getSymptom());
//            }
//
//        }
        Map<String, DiagnosisResult> resmap = new HashMap<>();

        List<DiagnosisResult> result = new ArrayList<>();
        for(Map.Entry<String, List<Symptoms>> entry : map.entrySet()){
            for(Long tx : symptoms) {
            for(Symptoms yum : entry.getValue()) {
//                  System.out.println("provided symptomId >> : "+tx + " matrix symptom id : "+yum.getId());
                  if(tx.equals(yum.getId())){
                   if(!resmap.containsKey(entry.getKey())) {
                       DiagnosisResult rs = new DiagnosisResult();
                       System.out.println("KEY VALUE >>> "+entry.getKey());
                       for(Symptoms tom: entry.getValue()) {
                           System.out.println("------------------LIST VALUE  >>>>>> "+ tom.getSymptom());
                       }
                       System.out.println("SAMPLE SIZE >>>> "+ entry.getValue().size());
                       Long samplesize = Long.valueOf(entry.getValue().size());
                       Double val = Double.valueOf(1);
                       rs.setSampleSize(samplesize);
                       rs.setConfidenceLevel(val);
                       rs.setDisease(entry.getKey());
                       List<Long> lo = new ArrayList<>();
                       lo.add(tx);
                       rs.setSymptoms(lo);
                       resmap.put(entry.getKey(),rs);
                   } else {

                       DiagnosisResult diagnosisResult = resmap.get(entry.getKey());
                       boolean isthere = false;
                       List<Long> symptoms2 = diagnosisResult.getSymptoms();
                       for(Long cr : symptoms2) {
                           if(tx.equals(cr)) {
                               isthere = true;
                           }
                       }
                       if(!isthere) {
                           diagnosisResult.setConfidenceLevel(diagnosisResult.getConfidenceLevel() + 1);
                           List<Long> symptoms1 = diagnosisResult.getSymptoms();
                           symptoms1.add(tx);
                           diagnosisResult.setSymptoms(symptoms1);
                       }

                   }

                  }
              }
            }

        }
        List<DiagnosisResult> fina = new ArrayList<>();
        System.out.println("respmap size : "+resmap.size());
        for (Map.Entry<String, DiagnosisResult> entry : resmap.entrySet()) {
            System.out.println("KEY VALUE >>> "+entry.getKey());
            System.out.println("-----------------VALUE >>>> "+ entry.getValue().getDisease());
            System.out.println("-----------------VALUE >>>> "+ entry.getValue().getConfidenceLevel());
            System.out.println("-----------------VALUE >>>> "+ entry.getValue().getSampleSize());
            System.out.println("-----------------VALUE >>>> "+ entry.getValue().getSymptoms());
            Long oSampSize = entry.getValue().getSampleSize();
            if(entry.getValue().getSymptoms().size() > 1){
                oSampSize = entry.getValue().getSampleSize()/entry.getValue().getSymptoms().size();
            }
            Double oPerceConf = (entry.getValue().getConfidenceLevel()/oSampSize) * 100;
            if(oPerceConf > 10) {
                entry.getValue().setSampleSize(oSampSize);
                entry.getValue().setConfidencePercent(oPerceConf);
                fina.add(entry.getValue());
            }
        }


        return fina;
    }
}
