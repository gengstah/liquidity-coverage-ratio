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

import org.geeksexception.liquidityratio.enums.UnsecuredWholesaleFundingType;

@Entity
@Access(AccessType.FIELD)
@Table(name = "UNSECURED_WHOLESALE_FUNDING")
public class UnsecuredWholesaleFunding implements Serializable {
	
	private static final long serialVersionUID = -5940942755269011062L;
	
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
	
	@Column(name = "UNSECURED_WHOLESALE_FUNDING_TYPE", nullable = false)
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

	public UnsecuredWholesaleFundingType getUnsecuredWholesaleFundingType() {
		return unsecuredWholesaleFundingType;
	}

	public void setUnsecuredWholesaleFundingType(
			UnsecuredWholesaleFundingType unsecuredWholesaleFundingType) {
		this.unsecuredWholesaleFundingType = unsecuredWholesaleFundingType;
	}
}