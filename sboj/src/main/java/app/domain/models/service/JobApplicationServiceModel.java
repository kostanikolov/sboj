package app.domain.models.service;

import app.domain.entities.SectorType;

import java.math.BigDecimal;

public class JobApplicationServiceModel {

    private String id;
    private SectorType sectorType;
    private String profession;
    private BigDecimal salary;
    private String description;

    public JobApplicationServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SectorType getSectorType() {
        return this.sectorType;
    }

    public void setSectorType(SectorType sectorType) {
        this.sectorType = sectorType;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
