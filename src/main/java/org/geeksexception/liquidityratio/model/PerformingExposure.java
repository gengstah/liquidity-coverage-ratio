package org.geeksexception.liquidityratio.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PERFORMING_EXPOSURE")
public class PerformingExposure extends CashInflow implements Serializable {
	
	private static final long serialVersionUID = -6068767609255537135L;
	
	public PerformingExposure() { }

}