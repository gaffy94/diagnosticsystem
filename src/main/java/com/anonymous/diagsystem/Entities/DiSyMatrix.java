package com.anonymous.diagsystem.Entities;

import javax.persistence.*;

@Entity
@Table(name = "disymmatrix")
public class DiSyMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "diseaseId")
    private Long diseaseId;
    @Column(name = "SymptomId")
    private Long symptomId;
    @OneToOne
    @JoinColumn(name = "diseaseId",referencedColumnName = "id", insertable =false, updatable =false)
    private Disease disease;
    @OneToOne
    @JoinColumn(name = "symptomId",referencedColumnName = "id", insertable =false, updatable =false)
    private Symptoms symptoms;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Long getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Long symptomId) {
        this.symptomId = symptomId;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {
        this.symptoms = symptoms;
    }
}
