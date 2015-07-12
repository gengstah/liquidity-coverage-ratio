package org.geeksexception.liquidityratio.web;

import java.util.List;

import javax.inject.Inject;

import org.geeksexception.liquidityratio.model.LiquidityCoverageRatio;
import org.geeksexception.liquidityratio.service.LiquidityCoverageRatioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lcr")
public class LiquidityCoverageRatioController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private @Inject LiquidityCoverageRatioService liquidityCoverageRatioService;
	
	public LiquidityCoverageRatioController() { }
	
	@RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	public LiquidityCoverageRatio findLiquidityCoverageRatioById(@PathVariable Long id) {
		logger.info("Fetching LiquidityCoverageRatio with id {}", id);
		
		return liquidityCoverageRatioService.findLiquidityCoverageRatio(id);
	}
	
	@RequestMapping(value="/list/{size}/{page}", method=RequestMethod.GET)
	public List<LiquidityCoverageRatio> findLiquidityCoverageRatios(@PathVariable Integer page, @PathVariable Integer size) {
		logger.info("Fetching LiquidityCoverageRatios with page {} and size {}", page, size);
		
		return liquidityCoverageRatioService.findLiquidityCoverageRatios(page, size);
	}
	
}