package org.geeksexception.liquidityratio.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CONTINGENT_FUNDING_OBLIGATION")
public class ContingentFundingObligation extends CashOutflow implements Serializable {
	
	private static final long serialVersionUID = 6286943590560851130L;
	
	public ContingentFundingObligation() { }
	
}