package org.geeksexception.liquidityratio.service;

import java.util.List;

import org.geeksexception.liquidityratio.model.LiquidityCoverageRatio;

public interface LiquidityCoverageRatioService {
	
	LiquidityCoverageRatio save(LiquidityCoverageRatio liquidityCoverageRatio);
	
	LiquidityCoverageRatio findLiquidityCoverageRatio(Long id);
	
	List<LiquidityCoverageRatio> findLiquidityCoverageRatios(Integer page, Integer size);
	
}