package com.anonymous.diagsystem.Controllers;

import com.anonymous.diagsystem.Entities.DiSyMatrix;
import com.anonymous.diagsystem.Entities.DiagnosisResult;
import com.anonymous.diagsystem.Entities.Symptoms;
import com.anonymous.diagsystem.Services.MainControllerService;
import com.anonymous.diagsystem.Services.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    SymptomService symptomService;
    @Autowired
    MainControllerService mainControllerService;
    @RequestMapping("/")
    public String index(){
       return "index";
    }
    @GetMapping("/test")
    public @ResponseBody
    String testend(){
        return "hello world";
    }

    @GetMapping("/symptoms")
    public @ResponseBody
    List<Symptoms> getSymptoms(){
        return symptomService.getAll();
    }

    @PostMapping("/dodiagnosis")
    public  @ResponseBody
    List<DiagnosisResult> doDiagnosis(@RequestBody List<Long> symptoms) {
        return mainControllerService.doDiagnosis(symptoms);
    }

}
