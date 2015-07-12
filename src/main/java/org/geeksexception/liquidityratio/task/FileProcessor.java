package org.geeksexception.liquidityratio.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import javax.inject.Inject;

import org.geeksexception.liquidityratio.model.LiquidityCoverageRatio;
import org.geeksexception.liquidityratio.service.LiquidityCoverageRatioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private @Inject LiquidityCoverageRatioService liquidityCoverageRatioService;
	
	public FileProcessor() { }
	
	public void processFile(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String currentLine;
		
		while((currentLine = reader.readLine()) != null) {
			logger.debug("{}", currentLine);
			LiquidityCoverageRatio liquidityCoverageRatio = convertLineToLiquidityCoverageRatio(currentLine);
			if(liquidityCoverageRatio != null) liquidityCoverageRatioService.save(liquidityCoverageRatio);
		}
		
		reader.close();
	}
	
	private LiquidityCoverageRatio convertLineToLiquidityCoverageRatio(String line) {
		String[] values = line.split(",");
		
		if(values.length != 28) { logger.error("Invalid values; length should be 28 but was {}", values.length); return null; }
		
		LiquidityCoverageRatio liquidityCoverageRatio = new LiquidityCoverageRatio();
		liquidityCoverageRatio.setTotalWeightedValueHQLA(new BigDecimal(values[0]));
		
		liquidityCoverageRatio.setTotalUnweightedStableDeposits(new BigDecimal(values[1]));
		liquidityCoverageRatio.setTotalWeightedStableDeposits(new BigDecimal(values[2]));
		
		liquidityCoverageRatio.setTotalUnweightedLessStableDeposits(new BigDecimal(values[3]));
		liquidityCoverageRatio.setTotalWeightedLessStableDeposits(new BigDecimal(values[4]));
		
		liquidityCoverageRatio.setTotalUnweightedOperationalDeposits(new BigDecimal(values[5]));
		liquidityCoverageRatio.setTotalWeightedOperationalDeposits(new BigDecimal(values[6]));
		
		liquidityCoverageRatio.setTotalUnweightedNonOperationalDeposits(new BigDecimal(values[7]));
		liquidityCoverageRatio.setTotalWeightedNonOperationalDeposits(new BigDecimal(values[8]));
		
		liquidityCoverageRatio.setTotalUnweightedUnsecuredDebt(new BigDecimal(values[9]));
		liquidityCoverageRatio.setTotalWeightedUnsecuredDebt(new BigDecimal(values[10]));
		
		liquidityCoverageRatio.setTotalWeightedSecuredWholesaleFunding(new BigDecimal(values[11]));
		
		liquidityCoverageRatio.setTotalUnweightedDerivativeExposureCollateralRequirements(new BigDecimal(values[12]));
		liquidityCoverageRatio.setTotalWeightedDerivativeExposureCollateralRequirements(new BigDecimal(values[13]));
		
		liquidityCoverageRatio.setTotalUnweightedLossOfFunding(new BigDecimal(values[14]));
		liquidityCoverageRatio.setTotalWeightedLossOfFunding(new BigDecimal(values[15]));
		
		liquidityCoverageRatio.setTotalUnweightedCreditAndLiquidityFacilities(new BigDecimal(values[16]));
		liquidityCoverageRatio.setTotalWeightedCreditAndLiquidityFacilities(new BigDecimal(values[17]));
		
		liquidityCoverageRatio.setTotalUnweightedContractualFundingObligations(new BigDecimal(values[18]));
		liquidityCoverageRatio.setTotalWeightedContractualFundingObligations(new BigDecimal(values[19]));
		
		liquidityCoverageRatio.setTotalUnweightedContingentFundingObligations(new BigDecimal(values[20]));
		liquidityCoverageRatio.setTotalWeightedContingentFundingObligations(new BigDecimal(values[21]));
		
		liquidityCoverageRatio.setTotalUnweightedSecuredLending(new BigDecimal(values[22]));
		liquidityCoverageRatio.setTotalWeightedSecuredLending(new BigDecimal(values[23]));
		
		liquidityCoverageRatio.setTotalUnweightedFullyPerformingExposures(new BigDecimal(values[24]));
		liquidityCoverageRatio.setTotalWeightedFullyPerformingExposures(new BigDecimal(values[25]));
		
		liquidityCoverageRatio.setTotalUnweightedOtherCashInflows(new BigDecimal(values[26]));
		liquidityCoverageRatio.setTotalWeightedOtherCashInflows(new BigDecimal(values[27]));
		
		return liquidityCoverageRatio;
	}
	
}