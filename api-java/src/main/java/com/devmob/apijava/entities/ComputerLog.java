package com.devmob.apijava.entities;

public class ComputerLog {

    private String fkEquipment;
    private Double cpuPercentage;
    private Long ramPercentage;

    public String getFkEquipment() {
        return fkEquipment;
    }

    public void setFkEquipment(String fkEquipment) {
        this.fkEquipment = fkEquipment;
    }

    public Double getCpuPercentage() {
        return cpuPercentage;
    }

    public void setCpuPercentage(Double cpuPercentage) {
        this.cpuPercentage = cpuPercentage;
    }

    public Long getRamPercentage() {
        return ramPercentage;
    }

    public void setRamPercentage(Long ramPercentage) {
        this.ramPercentage = ramPercentage;
    }

}
