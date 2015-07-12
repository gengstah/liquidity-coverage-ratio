package org.geeksexception.liquidityratio.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
@Table(name = "LIQUIDITY_COVERAGE_RATIO")
public class LiquidityCoverageRatio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "DATE_CREATED", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "TOTAL_WEIGHTED_VALUE_HQLA")
	private BigDecimal totalWeightedValueHQLA;
	
	@Transient
	private BigDecimal totalUnweightedRetailDeposits;
	
	@Transient
	private BigDecimal totalWeightedRetailDeposits;
	
	// Stable Deposits
	@Column(name = "TOTAL_UNWEIGHTED_STABLE_DEPOSITS")
	private BigDecimal totalUnweightedStableDeposits;
	
	@Column(name = "TOTAL_WEIGHTED_STABLE_DEPOSITS")
	private BigDecimal totalWeightedStableDeposits;
	
	// Less Stable Deposits
	@Column(name = "TOTAL_UNWEIGHTED_LESS_STABLE_DEPOSITS")
	private BigDecimal totalUnweightedLessStableDeposits;
	
	@Column(name = "TOTAL_WEIGHTED_LESS_STABLE_DEPOSITS")
	private BigDecimal totalWeightedLessStableDeposits;
	
	@Transient
	private BigDecimal totalUnweightedUnsecuredWholesaleFunding;
	
	@Transient
	private BigDecimal totalWeightedUnsecuredWholesaleFunding;
	
	// Operational Deposits
	@Column(name = "TOTAL_UNWEIGHTED_OPERATIONAL_DEPOSITS")
	private BigDecimal totalUnweightedOperationalDeposits;

	@Column(name = "TOTAL_WEIGHTED_OPERATIONAL_DEPOSITS")
	private BigDecimal totalWeightedOperationalDeposits;
	
	// Non-operational Deposits
	@Column(name = "TOTAL_UNWEIGHTED_NON_OPERATIONAL_DEPOSITS")
	private BigDecimal totalUnweightedNonOperationalDeposits;
	
	@Column(name = "TOTAL_WEIGHTED_NON_OPERATIONAL_DEPOSITS")
	private BigDecimal totalWeightedNonOperationalDeposits;
	
	// Unsecured Debt
	@Column(name = "TOTAL_UNWEIGHTED_UNSECURED_DEBT")
	private BigDecimal totalUnweightedUnsecuredDebt;
	
	@Column(name = "TOTAL_WEIGHTED_UNSECURED_DEBT")
	private BigDecimal totalWeightedUnsecuredDebt;
	
	// Total Secured Wholesale Funding
	@Column(name = "TOTAL_WEIGHTED_SECURED_WHOLESALE_FUNDING")
	private BigDecimal totalWeightedSecuredWholesaleFunding;
	
	@Transient
	private BigDecimal totalUnweightedAdditionalRequirements;
	
	@Transient
	private BigDecimal totalWeightedAdditionalRequirements;
	
	// Outflows - derivative exposures and other collateral requirements
	@Column(name = "TOTAL_UNWEIGHTED_DERIVATIVE_EXPOSURE")
	private BigDecimal totalUnweightedDerivativeExposureCollateralRequirements;
	
	@Column(name = "TOTAL_WEIGHTED_DERIVATIVE_EXPOSURE")
	private BigDecimal totalWeightedDerivativeExposureCollateralRequirements;
	
	// Outflows - loss of funding on debt products
	@Column(name = "TOTAL_UNWEIGHTED_LOSS_OF_FUNDING")
	private BigDecimal totalUnweightedLossOfFunding;
	
	@Column(name = "TOTAL_WEIGHTED_LOSS_OF_FUNDING")
	private BigDecimal totalWeightedLossOfFunding;
	
	// Credit and liquidity facilities
	@Column(name = "TOTAL_UNWEIGHTED_CREDIT_AND_LIQUIDITY")
	private BigDecimal totalUnweightedCreditAndLiquidityFacilities;
	
	@Column(name = "TOTAL_WEIGHTED_CREDIT_AND_LIQUIDITY")
	private BigDecimal totalWeightedCreditAndLiquidityFacilities;
	
	// Other contractual funding obligations
	@Column(name = "TOTAL_UNWEIGHTED_CONTRACTUAL_FUNDING")
	private BigDecimal totalUnweightedContractualFundingObligations;
	
	@Column(name = "TOTAL_WEIGHTED_CONTRACTUAL_FUNDING")
	private BigDecimal totalWeightedContractualFundingObligations;
	
	// Other contingent funding obligations
	@Column(name = "TOTAL_UNWEIGHTED_CONTINGENT_FUNDING")
	private BigDecimal totalUnweightedContingentFundingObligations;
	
	@Column(name = "TOTAL_WEIGHTED_CONTINGENT_FUNDING")
	private BigDecimal totalWeightedContingentFundingObligations;
	
	@Transient
	private BigDecimal totalWeightedCashOutflows;
	
	// Secured lending
	@Column(name = "TOTAL_UNWEIGHTED_SECURED_LENDING")
	private BigDecimal totalUnweightedSecuredLending;
	
	@Column(name = "TOTAL_WEIGHTED_SECURED_LENDING")
	private BigDecimal totalWeightedSecuredLending;
	
	// Inflows from fully performing exposures
	@Column(name = "TOTAL_UNWEIGHTED_PERFORMING_EXPOSURES")
	private BigDecimal totalUnweightedFullyPerformingExposures;
	
	@Column(name = "TOTAL_WEIGHTED_PERFORMING_EXPOSURES")
	private BigDecimal totalWeightedFullyPerformingExposures;
	
	// Other cash inflows
	@Column(name = "TOTAL_UNWEIGHTED_OTHER_CASH_INFLOWS")
	private BigDecimal totalUnweightedOtherCashInflows;
	
	@Column(name = "TOTAL_WEIGHTED_OTHER_CASH_INFLOWS")
	private BigDecimal totalWeightedOtherCashInflows;
	
	@Transient
	private BigDecimal totalUnweightedCashInflows;
	
	@Transient
	private BigDecimal totalWeightedCashInflows;
	
	@Transient
	private BigDecimal totalNetCashFlows;
	
	@Transient
	private BigDecimal liquidityCoverageRatio;
	
	public LiquidityCoverageRatio() { }
	
	@PrePersist
	public void prePersist() {
		createdDate = new Date();
	}
	
	@PostLoad
	public void postLoad() {
		getTotalUnweightedRetailDeposits();
		getTotalWeightedRetailDeposits();
		getTotalUnweightedUnsecuredWholesaleFunding();
		getTotalWeightedUnsecuredWholesaleFunding();
		getTotalUnweightedAdditionalRequirements();
		getTotalWeightedAdditionalRequirements();
		getTotalWeightedCashOutflows();
		getTotalUnweightedCashInflows();
		getTotalWeightedCashInflows();
		getTotalNetCashFlows();
		getLiquidityCoverageRatio();
	}
	
	public Long getId() {
		return id;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public BigDecimal getTotalWeightedValueHQLA() {
		return totalWeightedValueHQLA;
	}

	public void setTotalWeightedValueHQLA(BigDecimal totalWeightedValueHQLA) {
		this.totalWeightedValueHQLA = totalWeightedValueHQLA;
	}
	
	public BigDecimal getTotalUnweightedRetailDeposits() {
		totalUnweightedRetailDeposits = 
				totalUnweightedStableDeposits.add(totalUnweightedLessStableDeposits);
		
		return totalUnweightedRetailDeposits;
	}
	
	public BigDecimal getTotalWeightedRetailDeposits() {
		totalWeightedRetailDeposits = 
				totalWeightedStableDeposits.add(totalWeightedLessStableDeposits);
		
		return totalWeightedRetailDeposits;
	}

	public BigDecimal getTotalUnweightedStableDeposits() {
		return totalUnweightedStableDeposits;
	}

	public void setTotalUnweightedStableDeposits(
			BigDecimal totalUnweightedStableDeposits) {
		this.totalUnweightedStableDeposits = totalUnweightedStableDeposits;
	}

	public BigDecimal getTotalWeightedStableDeposits() {
		return totalWeightedStableDeposits;
	}

	public void setTotalWeightedStableDeposits(
			BigDecimal totalWeightedStableDeposits) {
		this.totalWeightedStableDeposits = totalWeightedStableDeposits;
	}

	public BigDecimal getTotalUnweightedLessStableDeposits() {
		return totalUnweightedLessStableDeposits;
	}

	public void setTotalUnweightedLessStableDeposits(
			BigDecimal totalUnweightedLessStableDeposits) {
		this.totalUnweightedLessStableDeposits = totalUnweightedLessStableDeposits;
	}

	public BigDecimal getTotalWeightedLessStableDeposits() {
		return totalWeightedLessStableDeposits;
	}

	public void setTotalWeightedLessStableDeposits(
			BigDecimal totalWeightedLessStableDeposits) {
		this.totalWeightedLessStableDeposits = totalWeightedLessStableDeposits;
	}
	
	public BigDecimal getTotalUnweightedUnsecuredWholesaleFunding() {
		totalUnweightedUnsecuredWholesaleFunding = 
				totalUnweightedOperationalDeposits
					.add(totalUnweightedNonOperationalDeposits)
					.add(totalUnweightedUnsecuredDebt);
		
		return totalUnweightedUnsecuredWholesaleFunding;
	}
	
	public BigDecimal getTotalWeightedUnsecuredWholesaleFunding() {
		totalWeightedUnsecuredWholesaleFunding = 
				totalWeightedOperationalDeposits
					.add(totalWeightedNonOperationalDeposits)
					.add(totalWeightedUnsecuredDebt);
		
		return totalWeightedUnsecuredWholesaleFunding;
	}

	public BigDecimal getTotalUnweightedOperationalDeposits() {
		return totalUnweightedOperationalDeposits;
	}

	public void setTotalUnweightedOperationalDeposits(
			BigDecimal totalUnweightedOperationalDeposits) {
		this.totalUnweightedOperationalDeposits = totalUnweightedOperationalDeposits;
	}

	public BigDecimal getTotalWeightedOperationalDeposits() {
		return totalWeightedOperationalDeposits;
	}

	public void setTotalWeightedOperationalDeposits(
			BigDecimal totalWeightedOperationalDeposits) {
		this.totalWeightedOperationalDeposits = totalWeightedOperationalDeposits;
	}

	public BigDecimal getTotalUnweightedNonOperationalDeposits() {
		return totalUnweightedNonOperationalDeposits;
	}

	public void setTotalUnweightedNonOperationalDeposits(
			BigDecimal totalUnweightedNonOperationalDeposits) {
		this.totalUnweightedNonOperationalDeposits = totalUnweightedNonOperationalDeposits;
	}

	public BigDecimal getTotalWeightedNonOperationalDeposits() {
		return totalWeightedNonOperationalDeposits;
	}

	public void setTotalWeightedNonOperationalDeposits(
			BigDecimal totalWeightedNonOperationalDeposits) {
		this.totalWeightedNonOperationalDeposits = totalWeightedNonOperationalDeposits;
	}

	public BigDecimal getTotalUnweightedUnsecuredDebt() {
		return totalUnweightedUnsecuredDebt;
	}

	public void setTotalUnweightedUnsecuredDebt(
			BigDecimal totalUnweightedUnsecuredDebt) {
		this.totalUnweightedUnsecuredDebt = totalUnweightedUnsecuredDebt;
	}

	public BigDecimal getTotalWeightedUnsecuredDebt() {
		return totalWeightedUnsecuredDebt;
	}

	public void setTotalWeightedUnsecuredDebt(BigDecimal totalWeightedUnsecuredDebt) {
		this.totalWeightedUnsecuredDebt = totalWeightedUnsecuredDebt;
	}

	public BigDecimal getTotalWeightedSecuredWholesaleFunding() {
		return totalWeightedSecuredWholesaleFunding;
	}

	public void setTotalWeightedSecuredWholesaleFunding(
			BigDecimal totalWeightedSecuredWholesaleFunding) {
		this.totalWeightedSecuredWholesaleFunding = totalWeightedSecuredWholesaleFunding;
	}
	
	public BigDecimal getTotalUnweightedAdditionalRequirements() {
		totalUnweightedAdditionalRequirements = 
				totalUnweightedDerivativeExposureCollateralRequirements
					.add(totalUnweightedLossOfFunding)
					.add(totalUnweightedCreditAndLiquidityFacilities);
		
		return totalUnweightedAdditionalRequirements;
	}
	
	public BigDecimal getTotalWeightedAdditionalRequirements() {
		totalWeightedAdditionalRequirements = 
				totalWeightedDerivativeExposureCollateralRequirements
					.add(totalWeightedLossOfFunding)
					.add(totalWeightedCreditAndLiquidityFacilities);
		
		return totalWeightedAdditionalRequirements;
	}

	public BigDecimal getTotalUnweightedDerivativeExposureCollateralRequirements() {
		return totalUnweightedDerivativeExposureCollateralRequirements;
	}

	public void setTotalUnweightedDerivativeExposureCollateralRequirements(
			BigDecimal totalUnweightedDerivativeExposureCollateralRequirements) {
		this.totalUnweightedDerivativeExposureCollateralRequirements = totalUnweightedDerivativeExposureCollateralRequirements;
	}

	public BigDecimal getTotalWeightedDerivativeExposureCollateralRequirements() {
		return totalWeightedDerivativeExposureCollateralRequirements;
	}

	public void setTotalWeightedDerivativeExposureCollateralRequirements(
			BigDecimal totalWeightedDerivativeExposureCollateralRequirements) {
		this.totalWeightedDerivativeExposureCollateralRequirements = totalWeightedDerivativeExposureCollateralRequirements;
	}

	public BigDecimal getTotalUnweightedLossOfFunding() {
		return totalUnweightedLossOfFunding;
	}

	public void setTotalUnweightedLossOfFunding(
			BigDecimal totalUnweightedLossOfFunding) {
		this.totalUnweightedLossOfFunding = totalUnweightedLossOfFunding;
	}

	public BigDecimal getTotalWeightedLossOfFunding() {
		return totalWeightedLossOfFunding;
	}

	public void setTotalWeightedLossOfFunding(BigDecimal totalWeightedLossOfFunding) {
		this.totalWeightedLossOfFunding = totalWeightedLossOfFunding;
	}

	public BigDecimal getTotalUnweightedCreditAndLiquidityFacilities() {
		return totalUnweightedCreditAndLiquidityFacilities;
	}

	public void setTotalUnweightedCreditAndLiquidityFacilities(
			BigDecimal totalUnweightedCreditAndLiquidityFacilities) {
		this.totalUnweightedCreditAndLiquidityFacilities = totalUnweightedCreditAndLiquidityFacilities;
	}

	public BigDecimal getTotalWeightedCreditAndLiquidityFacilities() {
		return totalWeightedCreditAndLiquidityFacilities;
	}

	public void setTotalWeightedCreditAndLiquidityFacilities(
			BigDecimal totalWeightedCreditAndLiquidityFacilities) {
		this.totalWeightedCreditAndLiquidityFacilities = totalWeightedCreditAndLiquidityFacilities;
	}

	public BigDecimal getTotalUnweightedContractualFundingObligations() {
		return totalUnweightedContractualFundingObligations;
	}

	public void setTotalUnweightedContractualFundingObligations(
			BigDecimal totalUnweightedContractualFundingObligations) {
		this.totalUnweightedContractualFundingObligations = totalUnweightedContractualFundingObligations;
	}

	public BigDecimal getTotalWeightedContractualFundingObligations() {
		return totalWeightedContractualFundingObligations;
	}

	public void setTotalWeightedContractualFundingObligations(
			BigDecimal totalWeightedContractualFundingObligations) {
		this.totalWeightedContractualFundingObligations = totalWeightedContractualFundingObligations;
	}

	public BigDecimal getTotalUnweightedContingentFundingObligations() {
		return totalUnweightedContingentFundingObligations;
	}

	public void setTotalUnweightedContingentFundingObligations(
			BigDecimal totalUnweightedContingentFundingObligations) {
		this.totalUnweightedContingentFundingObligations = totalUnweightedContingentFundingObligations;
	}

	public BigDecimal getTotalWeightedContingentFundingObligations() {
		return totalWeightedContingentFundingObligations;
	}

	public void setTotalWeightedContingentFundingObligations(
			BigDecimal totalWeightedContingentFundingObligations) {
		this.totalWeightedContingentFundingObligations = totalWeightedContingentFundingObligations;
	}
	
	public BigDecimal getTotalWeightedCashOutflows() {
		totalWeightedCashOutflows = 
				getTotalWeightedRetailDeposits()
					.add(getTotalWeightedUnsecuredWholesaleFunding())
					.add(getTotalWeightedSecuredWholesaleFunding())
					.add(getTotalWeightedAdditionalRequirements())
					.add(getTotalWeightedContractualFundingObligations())
					.add(getTotalWeightedContingentFundingObligations());
		
		return totalWeightedCashOutflows;
	}

	public BigDecimal getTotalUnweightedSecuredLending() {
		return totalUnweightedSecuredLending;
	}

	public void setTotalUnweightedSecuredLending(
			BigDecimal totalUnweightedSecuredLending) {
		this.totalUnweightedSecuredLending = totalUnweightedSecuredLending;
	}

	public BigDecimal getTotalWeightedSecuredLending() {
		return totalWeightedSecuredLending;
	}

	public void setTotalWeightedSecuredLending(
			BigDecimal totalWeightedSecuredLending) {
		this.totalWeightedSecuredLending = totalWeightedSecuredLending;
	}

	public BigDecimal getTotalUnweightedFullyPerformingExposures() {
		return totalUnweightedFullyPerformingExposures;
	}

	public void setTotalUnweightedFullyPerformingExposures(
			BigDecimal totalUnweightedFullyPerformingExposures) {
		this.totalUnweightedFullyPerformingExposures = totalUnweightedFullyPerformingExposures;
	}

	public BigDecimal getTotalWeightedFullyPerformingExposures() {
		return totalWeightedFullyPerformingExposures;
	}

	public void setTotalWeightedFullyPerformingExposures(
			BigDecimal totalWeightedFullyPerformingExposures) {
		this.totalWeightedFullyPerformingExposures = totalWeightedFullyPerformingExposures;
	}

	public BigDecimal getTotalUnweightedOtherCashInflows() {
		return totalUnweightedOtherCashInflows;
	}

	public void setTotalUnweightedOtherCashInflows(
			BigDecimal totalUnweightedOtherCashInflows) {
		this.totalUnweightedOtherCashInflows = totalUnweightedOtherCashInflows;
	}

	public BigDecimal getTotalWeightedOtherCashInflows() {
		return totalWeightedOtherCashInflows;
	}

	public void setTotalWeightedOtherCashInflows(
			BigDecimal totalWeightedOtherCashInflows) {
		this.totalWeightedOtherCashInflows = totalWeightedOtherCashInflows;
	}
	
	public BigDecimal getTotalUnweightedCashInflows() {
		totalUnweightedCashInflows = 
				getTotalUnweightedSecuredLending()
					.add(getTotalUnweightedFullyPerformingExposures())
					.add(getTotalUnweightedOtherCashInflows());
		
		return totalUnweightedCashInflows;
	}
	
	public BigDecimal getTotalWeightedCashInflows() {
		totalWeightedCashInflows = 
				getTotalWeightedSecuredLending()
					.add(getTotalWeightedFullyPerformingExposures())
					.add(getTotalWeightedOtherCashInflows());
		
		return totalWeightedCashInflows;
	}
	
	public BigDecimal getTotalNetCashFlows() {
		totalNetCashFlows = getTotalWeightedCashOutflows()
				.subtract(getTotalWeightedCashInflows());
		
		return totalNetCashFlows;
	}
	
	public BigDecimal getLiquidityCoverageRatio() {
		liquidityCoverageRatio = getTotalWeightedValueHQLA()
				.divide(getTotalNetCashFlows(), 4, RoundingMode.HALF_UP)
				.multiply(new BigDecimal("100"));
		
		return liquidityCoverageRatio;
	}
	
}