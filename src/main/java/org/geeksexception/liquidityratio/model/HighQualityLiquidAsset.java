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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="NOTE_ID", nullable = false)
	private Note note;
	
	@Column(name = "UNWEIGHTED_AMOUNT", nullable = false)
	private BigDecimal unweightedAmount;
	
	@Column(name = "LEVEL", nullable = false)
	@Enumerated(EnumType.STRING)
	private HighQualityLiquidAssetLevel highQualityLiquidAssetLevel;
	
	public HighQualityLiquidAsset() { }
	
	public HighQualityLiquidAsset(Note note, BigDecimal unweightedAmount, HighQualityLiquidAssetLevel highQualityLiquidAssetLevel) {
		this.note = note;
		this.unweightedAmount = unweightedAmount;
		this.highQualityLiquidAssetLevel = highQualityLiquidAssetLevel;
	}
	
	@PrePersist
	public void prePersist() {
		if(highQualityLiquidAssetLevel == null) highQualityLiquidAssetLevel = HighQualityLiquidAssetLevel.LEVEL1;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getUnweightedAmount() {
		return unweightedAmount;
	}

	public void setUnweightedAmount(BigDecimal unweightedAmount) {
		this.unweightedAmount = unweightedAmount;
	}
	
	public BigDecimal getWeightedAmount() {
		return unweightedAmount.subtract(unweightedAmount.multiply(note.getWeight()));
	}

	public HighQualityLiquidAssetLevel getHighQualityLiquidAssetLevel() {
		return highQualityLiquidAssetLevel;
	}

	public void setHighQualityLiquidAssetLevel(
			HighQualityLiquidAssetLevel highQualityLiquidAssetLevel) {
		this.highQualityLiquidAssetLevel = highQualityLiquidAssetLevel;
	}

	@Override
	public String toString() {
		return "HighQualityLiquidAsset [note=" + note + ", unweightedAmount="
				+ unweightedAmount + ", highQualityLiquidAssetLevel="
				+ highQualityLiquidAssetLevel + "]";
	}
	
}