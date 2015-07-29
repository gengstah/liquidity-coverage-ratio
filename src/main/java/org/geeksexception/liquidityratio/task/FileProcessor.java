package org.geeksexception.liquidityratio.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import javax.inject.Inject;

import org.geeksexception.liquidityratio.enums.HighQualityLiquidAssetLevel;
import org.geeksexception.liquidityratio.model.HighQualityLiquidAsset;
import org.geeksexception.liquidityratio.model.LiquidityCoverageRatio;
import org.geeksexception.liquidityratio.model.Note;
import org.geeksexception.liquidityratio.service.LiquidityCoverageRatioService;
import org.geeksexception.liquidityratio.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private @Inject LiquidityCoverageRatioService liquidityCoverageRatioService;
	
	private @Inject NoteService noteService;
	
	public FileProcessor() { }
	
	public void processFile(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String currentLine;
		
		while((currentLine = reader.readLine()) != null) {
			logger.debug("{}", currentLine);
			LiquidityCoverageRatio liquidityCoverageRatio = convertLineToLiquidityCoverageRatio(currentLine);
			//if(liquidityCoverageRatio != null) liquidityCoverageRatioService.save(liquidityCoverageRatio);
		}
		
		reader.close();
	}
	
	private LiquidityCoverageRatio convertLineToLiquidityCoverageRatio(String line) {
		String[] values = line.split(",");
		
		if(values.length != 2) { logger.warn("Skipping line: {}", line); return null; }
		
		LiquidityCoverageRatio liquidityCoverageRatio = new LiquidityCoverageRatio();
		
		Note note = noteService.findNoteByNoteId(new Long(values[0]));
		HighQualityLiquidAssetLevel level = getHighQualityLiquidAssetLevel(values[0]);
		HighQualityLiquidAsset highQualityLiquidAsset = new HighQualityLiquidAsset(note, new BigDecimal(values[1]), level);
		logger.info("HQLA: {}", highQualityLiquidAsset);
		return liquidityCoverageRatio;
	}

	private HighQualityLiquidAssetLevel getHighQualityLiquidAssetLevel(String noteId) {
		HighQualityLiquidAssetLevel level = HighQualityLiquidAssetLevel.LEVEL1;
		if(noteId.startsWith("11")) level = HighQualityLiquidAssetLevel.LEVEL1;
		if(noteId.startsWith("12")) level = HighQualityLiquidAssetLevel.LEVEL2A;
		if(noteId.startsWith("13")) level = HighQualityLiquidAssetLevel.LEVEL2B;
		return level;
	}
	
}