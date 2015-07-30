package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("HIGH_QUALITY_LIQUID_ASSET_CATEGORY")
public class HighQualityLiquidAssetCategory extends HighQualityLiquidAssetComponent implements Serializable {
	
	private static final long serialVersionUID = 7416253523692821689L;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany
	@JoinColumn(name="HIGH_QUALITY_LIQUID_ASSET_COMPONENT_ID")
	private List<HighQualityLiquidAssetComponent> highQualityLiquidAssetComponents = new ArrayList<HighQualityLiquidAssetComponent>();
	
	public HighQualityLiquidAssetCategory(String name) { this.name = name; }
	
	@Override
	public void add(
			HighQualityLiquidAssetComponent highQualityLiquidAssetComponent) {
		highQualityLiquidAssetComponents.add(highQualityLiquidAssetComponent);
	}
	
	@Override
	public void remove(
			HighQualityLiquidAssetComponent highQualityLiquidAssetComponent) {
		highQualityLiquidAssetComponents.remove(highQualityLiquidAssetComponent);
	}
	
	@Override
	public HighQualityLiquidAssetComponent getChild(Long noteId) {
		HighQualityLiquidAssetComponent child = null;
		
		for(HighQualityLiquidAssetComponent highQualityLiquidAssetComponent : highQualityLiquidAssetComponents) {
			if(highQualityLiquidAssetComponent instanceof HighQualityLiquidAssetCategory) {
				child = highQualityLiquidAssetComponent.getChild(noteId);
				if(child != null) return child;
			} else if(highQualityLiquidAssetComponent instanceof HighQualityLiquidAssetItem) {
				if(highQualityLiquidAssetComponent.getNote().getNoteId().equals(noteId)) return highQualityLiquidAssetComponent;
			}
		}
		
		return child;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public BigDecimal getUnweightedAmount() {
		BigDecimal totalUnweightedAmount = BigDecimal.ZERO;
		
		for(HighQualityLiquidAssetComponent highQualityLiquidAssetComponent : highQualityLiquidAssetComponents) {
			totalUnweightedAmount = totalUnweightedAmount.add(highQualityLiquidAssetComponent.getUnweightedAmount());
		}
		
		return totalUnweightedAmount;
	}
	
	@Override
	public BigDecimal getWeightedAmount() {
		BigDecimal totalWeightedAmount = BigDecimal.ZERO;
		
		for(HighQualityLiquidAssetComponent highQualityLiquidAssetComponent : highQualityLiquidAssetComponents) {
			totalWeightedAmount = totalWeightedAmount.add(highQualityLiquidAssetComponent.getWeightedAmount());
		}
		
		return totalWeightedAmount;
	}
	
}