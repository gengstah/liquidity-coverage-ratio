package org.geeksexception.liquidityratio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.geeksexception.liquidityratio.enums.RetailDepositType;

/*@Entity
@DiscriminatorValue("RETAIL_DEPOSIT")*/
public class RetailDeposit extends CashOutflow implements Serializable {
	
	private static final long serialVersionUID = -8736011150553614086L;
	
	@Column(name = "RETAIL_DEPOSIT_TYPE")
	@Enumerated(EnumType.STRING)
	private RetailDepositType retailDepositType;
	
	@ManyToOne
	@JoinColumn(name="NOTE_ID", nullable = false)
	private Note note;
	
	public RetailDeposit() { }
	
	@PrePersist
	public void prePersist() {
		if(retailDepositType == null) retailDepositType = RetailDepositType.STABLE;
	}

	public RetailDepositType getRetailDepositType() {
		return retailDepositType;
	}

	public void setRetailDepositType(RetailDepositType retailDepositType) {
		this.retailDepositType = retailDepositType;
	}
	
}