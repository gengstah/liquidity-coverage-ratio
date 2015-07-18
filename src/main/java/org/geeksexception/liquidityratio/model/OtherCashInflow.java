package org.geeksexception.liquidityratio.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OTHER_CASH_INFLOW")
public class OtherCashInflow extends CashInflow implements Serializable {
	
	private static final long serialVersionUID = -7798467310633972574L;
	
	public OtherCashInflow() { }

}