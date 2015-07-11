package org.geeksexception.liquidityratio.model;

import java.math.BigDecimal;

public class LiquidityCoverageRatio {
	
	private BigDecimal totalWeightedValueHQLA;
	
	public LiquidityCoverageRatio() { }

	public BigDecimal getTotalWeightedValueHQLA() {
		return totalWeightedValueHQLA;
	}

	public void setTotalWeightedValueHQLA(BigDecimal totalWeightedValueHQLA) {
		this.totalWeightedValueHQLA = totalWeightedValueHQLA;
	}
	
}