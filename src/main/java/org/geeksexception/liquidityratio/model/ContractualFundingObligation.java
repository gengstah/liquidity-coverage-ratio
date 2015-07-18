package org.geeksexception.liquidityratio.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CONTRACTUAL_FUNDING_OBLIGATION")
public class ContractualFundingObligation extends CashOutflow implements Serializable {
	
	private static final long serialVersionUID = 9135296563254444953L;
	
	public ContractualFundingObligation() { }
	
}