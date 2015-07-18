package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.geeksexception.liquidityratio.enums.HighQualityLiquidAssetLevel;

@Entity
@Table(name = "HIGH_QUALITY_LIQUID_ASSET")
public class HighQualityLiquidAsset implements Serializable {
	
	private static final long serialVersionUID = 5901421781866524929L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "UNWEIGHTED_AMOUNT")
	private BigDecimal unweightedAmount;
	
	@Column(name = "LEVEL")
	@Enumerated(EnumType.STRING)
	private HighQualityLiquidAssetLevel highQualityLiquidAssetLevel;
	
	@Column(name = "HAIRCUT")
	private BigDecimal haircut;
	
	public HighQualityLiquidAsset() { }
	
	public HighQualityLiquidAsset(String name, BigDecimal unweightedAmount) { 
		this.name = name; this.unweightedAmount = unweightedAmount; 
	}
	
	@PrePersist
	public void prePersist() {
		if(highQualityLiquidAssetLevel == null) highQualityLiquidAssetLevel = HighQualityLiquidAssetLevel.LEVEL1;
		if(haircut == null) {
			if(highQualityLiquidAssetLevel == HighQualityLiquidAssetLevel.LEVEL1) haircut = BigDecimal.ZERO;
			else if(highQualityLiquidAssetLevel == HighQualityLiquidAssetLevel.LEVEL2A) haircut = new BigDecimal("0.15");
			else if(highQualityLiquidAssetLevel == HighQualityLiquidAssetLevel.LEVEL2B) haircut = new BigDecimal("0.25");;
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
		return unweightedAmount.subtract(unweightedAmount.multiply(haircut));
	}

	public HighQualityLiquidAssetLevel getHighQualityLiquidAssetLevel() {
		return highQualityLiquidAssetLevel;
	}

	public void setHighQualityLiquidAssetLevel(
			HighQualityLiquidAssetLevel highQualityLiquidAssetLevel) {
		this.highQualityLiquidAssetLevel = highQualityLiquidAssetLevel;
	}

	public BigDecimal getHaircut() {
		return haircut;
	}

	public void setHaircut(BigDecimal haircut) {
		this.haircut = haircut;
	}
	
}