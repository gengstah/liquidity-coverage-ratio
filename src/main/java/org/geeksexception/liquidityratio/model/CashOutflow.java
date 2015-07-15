package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
@Table(name = "CASH_OUTFLOW")
public class CashOutflow implements Serializable {
	
	private static final long serialVersionUID = 2665139265252766263L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="RETAIL_DEPOSIT_ID")
	private List<RetailDeposit> retailDeposit;
	
	@ManyToOne
	@JoinColumn(name="UNSECURED_WHOLESALE_FUNDING_ID")
	private List<UnsecuredWholesaleFunding> unsecuredWholesaleFunding;
	
	@ManyToOne
	@JoinColumn(name="SECURED_WHOLESALE_FUNDING_ID")
	private List<SecuredWholesaleFunding> securedWholesaleFunding;
	
	@ManyToOne
	@JoinColumn(name="ADDITIONAL_REQUIREMENT_ID")
	private List<AdditionalRequirement> additionalRequirement;
	
	@ManyToOne
	@JoinColumn(name="CONTRACTUAL_FUNDING_OBLIGATION_ID")
	private List<ContractualFundingObligation> contractualFundingObligation;
	
	@ManyToOne
	@JoinColumn(name="CONTINGENT_FUNDING_OBLIGATION_ID")
	private List<ContingentFundingObligation> contingentFundingObligation;
	
	@Transient
	private BigDecimal totalCashOutflow;
	
	public CashOutflow() { }

	public Long getId() {
		return id;
	}

	public List<RetailDeposit> getRetailDeposit() {
		return retailDeposit;
	}

	public void setRetailDeposit(List<RetailDeposit> retailDeposit) {
		this.retailDeposit = retailDeposit;
	}

	public List<UnsecuredWholesaleFunding> getUnsecuredWholesaleFunding() {
		return unsecuredWholesaleFunding;
	}

	public void setUnsecuredWholesaleFunding(
			List<UnsecuredWholesaleFunding> unsecuredWholesaleFunding) {
		this.unsecuredWholesaleFunding = unsecuredWholesaleFunding;
	}

	public List<SecuredWholesaleFunding> getSecuredWholesaleFunding() {
		return securedWholesaleFunding;
	}

	public void setSecuredWholesaleFunding(
			List<SecuredWholesaleFunding> securedWholesaleFunding) {
		this.securedWholesaleFunding = securedWholesaleFunding;
	}

	public List<AdditionalRequirement> getAdditionalRequirement() {
		return additionalRequirement;
	}

	public void setAdditionalRequirement(
			List<AdditionalRequirement> additionalRequirement) {
		this.additionalRequirement = additionalRequirement;
	}

	public List<ContractualFundingObligation> getContractualFundingObligation() {
		return contractualFundingObligation;
	}

	public void setContractualFundingObligation(
			List<ContractualFundingObligation> contractualFundingObligation) {
		this.contractualFundingObligation = contractualFundingObligation;
	}

	public List<ContingentFundingObligation> getContingentFundingObligation() {
		return contingentFundingObligation;
	}

	public void setContingentFundingObligation(
			List<ContingentFundingObligation> contingentFundingObligation) {
		this.contingentFundingObligation = contingentFundingObligation;
	}

	public BigDecimal getTotalCashOutflow() {
		// TODO: computation of total cash outflow
		return totalCashOutflow;
	}

}