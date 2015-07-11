package org.geeksexception.liquidityratio.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.geeksexception.liquidityratio.model.LiquidityCoverageRatio;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class MockRepository {
	
	public JRDataSource getDataSource() {
		List<LiquidityCoverageRatio> liquidityCoverageRatios = new ArrayList<LiquidityCoverageRatio>();
		LiquidityCoverageRatio ratio = new LiquidityCoverageRatio();
		ratio.setTotalWeightedValueHQLA(new BigDecimal("6666.66"));
		liquidityCoverageRatios.add(ratio);
		return new JRBeanCollectionDataSource(liquidityCoverageRatios);
	}
	
}