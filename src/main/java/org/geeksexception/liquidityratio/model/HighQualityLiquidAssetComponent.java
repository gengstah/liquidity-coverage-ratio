package org.geeksexception.liquidityratio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.geeksexception.liquidityratio.enums.HighQualityLiquidAssetLevel;

@Entity
@Access(AccessType.FIELD)
@Table(name = "HIGH_QUALITY_LIQUID_ASSET")
@Inheritance
@DiscriminatorColumn(name="HIGH_QUALITY_LIQUID_ASSET_TYPE")
public abstract class HighQualityLiquidAssetComponent implements Serializable {
	
	private static final long serialVersionUID = 7654237139083713350L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	protected Long id;
	
	public HighQualityLiquidAssetComponent() { }
	
	public void add(HighQualityLiquidAssetComponent highQualityLiquidAssetComponent) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(HighQualityLiquidAssetComponent highQualityLiquidAssetComponent) {
		throw new UnsupportedOperationException();
	}
	
	public HighQualityLiquidAssetComponent getChild(Long noteId) {
		throw new UnsupportedOperationException();
	}
	
	public Long getId() {
		throw new UnsupportedOperationException();
	}
	
	public String getName() {
		throw new UnsupportedOperationException();
	}
	
	public BigDecimal getUnweightedAmount() {
		throw new UnsupportedOperationException();
	}
	
	public BigDecimal getWeightedAmount() {
		throw new UnsupportedOperationException();
	}
	
	public Note getNote() {
		throw new UnsupportedOperationException();
	}
	
	public HighQualityLiquidAssetLevel getHighQualityLiquidAssetLevel() {
		throw new UnsupportedOperationException();
	}
	
}