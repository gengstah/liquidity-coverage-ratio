package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;

import org.geeksexception.liquidityratio.enums.AdditionalRequirementType;

@Entity
@DiscriminatorValue("ADDITIONAL_REQUIREMENT")
public class AdditionalRequirement extends CashOutflow implements Serializable {
	
	private static final long serialVersionUID = -2750632584242148237L;
	
	@Column(name = "ADDITIONAL_REQUIREMENT_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private AdditionalRequirementType additionalRequirementType;
	
	public AdditionalRequirement() { }
	
	@PrePersist
	public void prePersist() {
		if(additionalRequirementType == null) additionalRequirementType = AdditionalRequirementType.DERIVATIVE_EXPOSURES;
		if(additionalRequirementType == AdditionalRequirementType.DERIVATIVE_EXPOSURES) runOffRate = new BigDecimal("0.25");
		else if(additionalRequirementType == AdditionalRequirementType.LOSS_OF_FUNDING) runOffRate = new BigDecimal("0.25");
		else if(additionalRequirementType == AdditionalRequirementType.CREDIT_AND_LIQUIDITY_FACILITIES) runOffRate = new BigDecimal("0.25");
	}

	public AdditionalRequirementType getAdditionalRequirementType() {
		return additionalRequirementType;
	}

	public void setAdditionalRequirementType(AdditionalRequirementType additionalRequirementType) {
		this.additionalRequirementType = additionalRequirementType;
	}
	
}