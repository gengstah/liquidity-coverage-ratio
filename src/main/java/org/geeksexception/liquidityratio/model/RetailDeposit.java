package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.geeksexception.liquidityratio.enums.RetailDepositType;

@Entity
@Access(AccessType.FIELD)
@Table(name = "RETAIL_DEPOSIT")
public class RetailDeposit implements Serializable {
	
	private static final long serialVersionUID = -8736011150553614086L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "UNWEIGHTED_AMOUNT", nullable = false)
	private BigDecimal unweightedAmount;
	
	@Column(name = "UNWEIGHTED_AMOUNT", nullable = false)
	private BigDecimal runOffRate;
	
	@Column(name = "UNWEIGHTED_AMOUNT", nullable = false)
	@Enumerated(EnumType.STRING)
	private RetailDepositType retailDepositType;
	
	public RetailDeposit() { }
	
	@PrePersist
	public void prePersist() {
		if(retailDepositType == null) retailDepositType = RetailDepositType.STABLE;
		if(runOffRate == null) {
			if(retailDepositType == RetailDepositType.STABLE) runOffRate = new BigDecimal("0.05");
			else runOffRate = new BigDecimal("0.1");
		}
	}

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

	public BigDecimal getWeightedAmount() {
		return unweightedAmount.multiply(runOffRate);
	}

	public BigDecimal getRunOffRate() {
		return runOffRate;
	}

	public void setRunOffRate(BigDecimal runOffRate) {
		this.runOffRate = runOffRate;
	}

	public RetailDepositType getRetailDepositType() {
		return retailDepositType;
	}

	public void setRetailDepositType(RetailDepositType retailDepositType) {
		this.retailDepositType = retailDepositType;
	}
}