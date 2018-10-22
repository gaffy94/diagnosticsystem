package com.anonymous.diagsystem.Entities;

import java.util.List;

public class DiagnosisResult {

    String disease;
    Double confidenceLevel;
    Long sampleSize;
    List<Long> symptoms;
    Double confidencePercent;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Double getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(Double confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    public Long getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(Long sampleSize) {
        this.sampleSize = sampleSize;
    }

    public List<Long> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Long> symptoms) {
        this.symptoms = symptoms;
    }

    public Double getConfidencePercent() {
        return confidencePercent;
    }

    public void setConfidencePercent(Double confidencePercent) {
        this.confidencePercent = confidencePercent;
    }
}
