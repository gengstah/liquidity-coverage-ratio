package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.geeksexception.liquidityratio.enums.HighQualityLiquidAssetLevel;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("HIGH_QUALITY_LIQUID_ASSET_ITEMS")
public class HighQualityLiquidAssetItem extends HighQualityLiquidAssetComponent implements Serializable {
	
	private static final long serialVersionUID = -1577296618754709025L;
	
	@ManyToOne
	@JoinColumn(name="NOTE_ID", nullable = false)
	private Note note;
	
	@Column(name = "UNWEIGHTED_AMOUNT", nullable = false)
	private BigDecimal unweightedAmount;
	
	@Column(name = "LEVEL", nullable = false)
	@Enumerated(EnumType.STRING)
	private HighQualityLiquidAssetLevel highQualityLiquidAssetLevel;
	
	public HighQualityLiquidAssetItem(Note note, BigDecimal unweightedAmount, HighQualityLiquidAssetLevel highQualityLiquidAssetLevel) {
		this.note = note;
		this.unweightedAmount = unweightedAmount;
		this.highQualityLiquidAssetLevel = highQualityLiquidAssetLevel;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return note.getDescription();
	}
	
	@Override
	public Note getNote() {
		return note;
	}
	
	@Override
	public HighQualityLiquidAssetLevel getHighQualityLiquidAssetLevel() {
		return highQualityLiquidAssetLevel;
	}
	
	@Override
	public BigDecimal getUnweightedAmount() {
		return unweightedAmount;
	}
	
	@Override
	public BigDecimal getWeightedAmount() {
		return unweightedAmount.multiply(note.getWeight());
	}

}