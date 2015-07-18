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

@Entity
@Access(AccessType.FIELD)
@Table(name = "CASH_INFLOW")
@Inheritance
@DiscriminatorColumn(name="CASH_INFLOW_TYPE")
public class CashInflow implements Serializable {
	
	private static final long serialVersionUID = 2665139265252766263L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "UNWEIGHTED_AMOUNT")
	private BigDecimal unweightedAmount;
	
	@Column(name = "INFLOW_RATE")
	protected BigDecimal inflowRate;
	
	public CashInflow() { }

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnweightedAmount() {
		return unweightedAmount;
	}

	public void setUnweightedAmount(BigDecimal unweightedAmount) {
		this.unweightedAmount = unweightedAmount;
	}

	public BigDecimal getInflowRate() {
		return inflowRate;
	}

	public void setInflowRate(BigDecimal inflowRate) {
		this.inflowRate = inflowRate;
	}
}