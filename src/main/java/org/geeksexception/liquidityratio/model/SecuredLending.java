package org.geeksexception.liquidityratio.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SECURED_LENDING")
public class SecuredLending extends CashInflow implements Serializable {
	
	private static final long serialVersionUID = -2547694860651918617L;
	
	public SecuredLending() { }
	
}