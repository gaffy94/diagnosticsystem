package com.anonymous.diagsystem.Utilities;

import com.anonymous.diagsystem.Dao.DiSyMatrixDao;
import com.anonymous.diagsystem.Dao.DiseaseDao;
import com.anonymous.diagsystem.Dao.SymptomDao;
import com.anonymous.diagsystem.Entities.DiSyMatrix;
import com.anonymous.diagsystem.Entities.Disease;
import com.anonymous.diagsystem.Entities.Symptoms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class Util {
    @Autowired
    SymptomDao symptomDao;
    @Autowired
    DiseaseDao diseaseDao;
    @Autowired
    DiSyMatrixDao diSyMatrixDao;

    public void writeToJSON() {
//        String csvFile = "D:\\symatrix.csv";
//        BufferedReader br = null;
//        String line = "";
//        String cvsSplitBy = ",";
//        String keyhead = "";
//        String tempkey = "";
////        String tempvalue = "";
//        String newkey = "";
//        String newvalue = "";
//        Map<String, String> map = new HashMap<>();
//
//        try {
//
//            br = new BufferedReader(new FileReader(csvFile));
//            int i = 0;
//            while ((line = br.readLine()) != null) {
//                String[] keyvalue = line.split(cvsSplitBy);
//                newkey = keyvalue[0];
//                newvalue = keyvalue[1];
//
//                System.out.println("New Key : " + newkey);
//                System.out.println("New Value: " + newvalue);
////     map.put(newvalue, newvalue);
//                DiSyMatrix matrix = new DiSyMatrix();
//                Optional<Symptoms> symp = symptomDao.findBySymptom(newvalue);
//                Optional<Disease> dis = diseaseDao.findByDisease(newkey);
//                matrix.setDiseaseId(dis.get().getId());
//                matrix.setSymptomId(symp.get().getId());
//                diSyMatrixDao.save(matrix);
//            }
//            diSyMatrixDao.flush();
////            System.out.println("Size is : " + map.size());
////
////            for (Map.Entry<String, String> entry : map.entrySet()) {
////                Symptoms dis = new Symptoms();
////                dis.setSymptom(entry.getKey());
////                System.out.println("Saving Entry : " + entry.getKey());
////                symptomDao.save(dis);
////            }
////            symptomDao.flush();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }
}
