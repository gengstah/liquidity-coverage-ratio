package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name = "WEIGHTED_AMOUNT")
	private BigDecimal weightedAmount;
	
	@Column(name = "LEVEL")
	@Enumerated(EnumType.STRING)
	private HighQualityLiquidAssetLevel highQualityLiquidAssetLevel;
	
	@OneToMany(mappedBy="highQualityLiquidAssetParent")
	private List<HighQualityLiquidAsset> highQualityLiquidAssetChildren;
	
	@ManyToOne
	@JoinColumn(name="HIGH_QUALITY_LIQUID_ASSET_PARENT_ID")
	private HighQualityLiquidAsset highQualityLiquidAssetParent;
	
	public HighQualityLiquidAsset() { }
	
	public HighQualityLiquidAsset(String name, BigDecimal weightedAmount) { 
		this.name = name; this.weightedAmount = weightedAmount; 
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

	public BigDecimal getWeightedAmount() {
		return weightedAmount;
	}

	public void setWeightedAmount(BigDecimal weightedAmount) {
		this.weightedAmount = weightedAmount;
	}

	public HighQualityLiquidAssetLevel getHighQualityLiquidAssetLevel() {
		return highQualityLiquidAssetLevel;
	}

	public void setHighQualityLiquidAssetLevel(
			HighQualityLiquidAssetLevel highQualityLiquidAssetLevel) {
		this.highQualityLiquidAssetLevel = highQualityLiquidAssetLevel;
	}

	public List<HighQualityLiquidAsset> getHighQualityLiquidAssetChildren() {
		return highQualityLiquidAssetChildren;
	}

	public void setHighQualityLiquidAssetChildren(
			List<HighQualityLiquidAsset> highQualityLiquidAssetChildren) {
		this.highQualityLiquidAssetChildren = highQualityLiquidAssetChildren;
	}
	
	public void addHighQualityLiquidAssetChildren(HighQualityLiquidAsset highQualityLiquidAsset) {
		if(highQualityLiquidAssetChildren == null) 
			this.highQualityLiquidAssetChildren = new ArrayList<HighQualityLiquidAsset>();
		
		this.highQualityLiquidAssetChildren.add(highQualityLiquidAsset);
	}

	public HighQualityLiquidAsset getHighQualityLiquidAssetParent() {
		return highQualityLiquidAssetParent;
	}

	public void setHighQualityLiquidAssetParent(HighQualityLiquidAsset highQualityLiquidAssetParent) {
		this.highQualityLiquidAssetParent = highQualityLiquidAssetParent;
	}
	
	public BigDecimal computeTotalWeightedAmount() {
		BigDecimal totalWeightedAmount = BigDecimal.ZERO;
		if(highQualityLiquidAssetChildren != null && highQualityLiquidAssetChildren.size() > 0) {
			for(HighQualityLiquidAsset asset : highQualityLiquidAssetChildren) {
				totalWeightedAmount = totalWeightedAmount.add(asset.computeTotalWeightedAmount());
			}
		} else {
			totalWeightedAmount = totalWeightedAmount.add(this.weightedAmount);
		}
		
		return totalWeightedAmount;
	}

	@Override
	public String toString() {
		return "HighQualityLiquidAsset [id=" + id + ", name=" + name
				+ ", weightedAmount=" + weightedAmount
				+ ", highQualityLiquidAssetLevel="
				+ highQualityLiquidAssetLevel + "]";
	}
	
}