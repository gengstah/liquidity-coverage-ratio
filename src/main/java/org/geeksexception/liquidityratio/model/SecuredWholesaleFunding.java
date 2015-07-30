package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*@Entity
@DiscriminatorValue("SECURED_WHOLESALE_FUNDING")*/
public class SecuredWholesaleFunding extends CashOutflow implements Serializable {
	
	private static final long serialVersionUID = -5656561040459767109L;
	
	@Column(name = "WEIGHTED_AMOUNT")
	private BigDecimal weightedAmount;
	
	public SecuredWholesaleFunding() { }

	public BigDecimal getWeightedAmount() {
		return weightedAmount;
	}

	public void setWeightedAmount(BigDecimal weightedAmount) {
		this.weightedAmount = weightedAmount;
	}
	
}