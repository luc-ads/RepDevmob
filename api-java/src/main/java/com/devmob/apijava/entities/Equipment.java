package com.devmob.apijava.entities;

public class Equipment {

    private String idEquipment;
    private Integer fkUser;
    private String operationalSystem;
    private String manufacturer;
    private String architecture;
    private String equipmentRam;
    private String equipmentHd;
    private String nameProcessor;
    private int physicalCpus;
    private int logicalCpus;

    public String getIdEquipment() {
        return idEquipment;
    }

    public void setIdEquipment(String idEquipment) {
        this.idEquipment = idEquipment;
    }

    public Integer getFkUser() {
        return fkUser;
    }

    public void setFkUser(Integer fkUser) {
        this.fkUser = fkUser;
    }

    public String getOperationalSystem() {
        return operationalSystem;
    }

    public void setOperationalSystem(String operationalSystem) {
        this.operationalSystem = operationalSystem;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getEquipmentRam() {
        return equipmentRam;
    }

    public void setEquipmentRam(String equipmentRam) {
        this.equipmentRam = equipmentRam;
    }

    public String getEquipmentHd() {
        return equipmentHd;
    }

    public void setEquipmentHd(String equipmentHd) {
        this.equipmentHd = equipmentHd;
    }

    public String getNameProcessor() {
        return nameProcessor;
    }

    public void setNameProcessor(String nameProcessor) {
        this.nameProcessor = nameProcessor;
    }

    public int getPhysicalCpus() {
        return physicalCpus;
    }

    public void setPhysicalCpus(int physicalCpus) {
        this.physicalCpus = physicalCpus;
    }

    public int getLogicalCpus() {
        return logicalCpus;
    }

    public void setLogicalCpus(int logicalCpus) {
        this.logicalCpus = logicalCpus;
    }
}
