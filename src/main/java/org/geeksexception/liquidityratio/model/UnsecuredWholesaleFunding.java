package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;

import org.geeksexception.liquidityratio.enums.UnsecuredWholesaleFundingType;

@Entity
@DiscriminatorValue("UNSECURED_WHOLESALE_FUNDING")
public class UnsecuredWholesaleFunding extends CashOutflow implements Serializable {
	
	private static final long serialVersionUID = -5940942755269011062L;
	
	@Column(name = "UNSECURED_WHOLESALE_FUNDING_TYPE")
	@Enumerated(EnumType.STRING)
	private UnsecuredWholesaleFundingType unsecuredWholesaleFundingType;
	
	public UnsecuredWholesaleFunding() { }
	
	@PrePersist
	public void prePersist() {
		if(unsecuredWholesaleFundingType == null) unsecuredWholesaleFundingType = UnsecuredWholesaleFundingType.OPERATIONAL;
		if(runOffRate == null) {
			if(unsecuredWholesaleFundingType == UnsecuredWholesaleFundingType.OPERATIONAL) runOffRate = new BigDecimal("0.25");
			else if(unsecuredWholesaleFundingType == UnsecuredWholesaleFundingType.NON_OPERATIONAL) runOffRate = new BigDecimal("0.4");
			else if(unsecuredWholesaleFundingType == UnsecuredWholesaleFundingType.UNSECURED_DEBT) runOffRate = new BigDecimal("1.00");
		}
	}

	public UnsecuredWholesaleFundingType getUnsecuredWholesaleFundingType() {
		return unsecuredWholesaleFundingType;
	}

	public void setUnsecuredWholesaleFundingType(
			UnsecuredWholesaleFundingType unsecuredWholesaleFundingType) {
		this.unsecuredWholesaleFundingType = unsecuredWholesaleFundingType;
	}
	
}