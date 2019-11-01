package app.domain.models.binding;

import java.math.BigDecimal;

public class JobCreateBindingModel {

	private String sectorType;
	private String profession;
	private BigDecimal salary;
	private String description;

	public JobCreateBindingModel() {
	}

	public String getSectorType() {
		return this.sectorType;
	}

	public void setSectorType(String sectorType) {
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
