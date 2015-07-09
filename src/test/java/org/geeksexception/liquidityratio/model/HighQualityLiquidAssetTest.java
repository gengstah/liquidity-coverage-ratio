package org.geeksexception.liquidityratio.model;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HighQualityLiquidAssetTest {
	
	private HighQualityLiquidAsset highQualityLiquidAsset;
	
	@Before
	public void setUp() {
		highQualityLiquidAsset = new HighQualityLiquidAsset("PARENT", BigDecimal.ZERO);
		
		highQualityLiquidAsset.addHighQualityLiquidAssetChildren(new HighQualityLiquidAsset("CHILD1", new BigDecimal("4444.4444")));
		highQualityLiquidAsset.addHighQualityLiquidAssetChildren(new HighQualityLiquidAsset("CHILD2", new BigDecimal("55555.55555")));
	}
	
	@Test
	public void testComputeTotalWeightedAmount() {
		Assert.assertEquals(new BigDecimal("59999.99995"), highQualityLiquidAsset.computeTotalWeightedAmount());
	}
	
}