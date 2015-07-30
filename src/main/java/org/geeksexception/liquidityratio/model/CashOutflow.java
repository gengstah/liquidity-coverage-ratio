package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

/*@Entity
@Access(AccessType.FIELD)
@Table(name = "CASH_OUTFLOW")
@Inheritance
@DiscriminatorColumn(name="CASH_OUTFLOW_TYPE")*/
public abstract class CashOutflow implements Serializable {
	
	private static final long serialVersionUID = 2665139265252766263L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "UNWEIGHTED_AMOUNT")
	private BigDecimal unweightedAmount;
	
	public CashOutflow() { }

	public Long getId() {
		return id;
	}

	public BigDecimal getUnweightedAmount() {
		return unweightedAmount;
	}

	public void setUnweightedAmount(BigDecimal unweightedAmount) {
		this.unweightedAmount = unweightedAmount;
	}

}