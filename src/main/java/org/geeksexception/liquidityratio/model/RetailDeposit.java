package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;

import org.geeksexception.liquidityratio.enums.RetailDepositType;

@Entity
@DiscriminatorValue("RETAIL_DEPOSIT")
public class RetailDeposit extends CashOutflow implements Serializable {
	
	private static final long serialVersionUID = -8736011150553614086L;
	
	@Column(name = "UNWEIGHTED_AMOUNT", nullable = false)
	@Enumerated(EnumType.STRING)
	private RetailDepositType retailDepositType;
	
	public RetailDeposit() { }
	
	@PrePersist
	public void prePersist() {
		if(retailDepositType == null) retailDepositType = RetailDepositType.STABLE;
		if(runOffRate == null) {
			if(retailDepositType == RetailDepositType.STABLE) runOffRate = new BigDecimal("0.05");
			else runOffRate = new BigDecimal("0.1");
		}
	}

	public RetailDepositType getRetailDepositType() {
		return retailDepositType;
	}

	public void setRetailDepositType(RetailDepositType retailDepositType) {
		this.retailDepositType = retailDepositType;
	}
	
}