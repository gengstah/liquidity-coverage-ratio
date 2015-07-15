package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
@Table(name = "CASH_INFLOW")
public class CashInflow implements Serializable {
	
	private static final long serialVersionUID = 2665139265252766263L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="SECURED_LENDING")
	private SecuredLending securedLending;
	
	@ManyToOne
	@JoinColumn(name="PERFORMING_EXPOSURE")
	private PerformingExposure performingExposure;
	
	@ManyToOne
	@JoinColumn(name="OTHER_CASH_INFLOW")
	private OtherCashInflow otherCashInflow;
	
	@Transient
	private BigDecimal totalCashOutflow;
	
	public CashInflow() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SecuredLending getSecuredLending() {
		return securedLending;
	}

	public void setSecuredLending(SecuredLending securedLending) {
		this.securedLending = securedLending;
	}

	public PerformingExposure getPerformingExposure() {
		return performingExposure;
	}

	public void setPerformingExposure(PerformingExposure performingExposure) {
		this.performingExposure = performingExposure;
	}

	public OtherCashInflow getOtherCashInflow() {
		return otherCashInflow;
	}

	public void setOtherCashInflow(OtherCashInflow otherCashInflow) {
		this.otherCashInflow = otherCashInflow;
	}

	public BigDecimal getTotalCashOutflow() {
		// TODO: computation of total cash inflow
		return totalCashOutflow;
	}

}