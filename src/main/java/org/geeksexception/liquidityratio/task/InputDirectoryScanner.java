package org.geeksexception.liquidityratio.task;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:/config.properties"})
public class InputDirectoryScanner {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private @Inject Environment env;
	
	private @Inject FileProcessor fileProcessor;
	
	public InputDirectoryScanner() { }
	
	@Scheduled(fixedDelay = 3000)
	public void processInputFile() throws IOException {
		File inputDirectory = new File(env.getProperty("input.scan.directory"));
		String[] fileNames = inputDirectory.list();
		
		for(String fileName : fileNames) {
			File file = new File(env.getProperty("input.scan.directory") + "/" + fileName);
			if(file.isDirectory() || !fileName.substring(fileName.lastIndexOf('.')+1).equalsIgnoreCase(env.getProperty("input.scan.extension"))) continue;
			
			logger.info("Processing file {}", fileName);
			fileProcessor.processFile(file);
			
			moveFileToProcessedDirectory(file);
		}
		
	}

	private void moveFileToProcessedDirectory(File file) throws IOException {
		File processedDirectory = new File(env.getProperty("input.scan.processed.directory"));
		if(!processedDirectory.exists()) processedDirectory.mkdir();
		FileUtils.copyFile(file, new File(env.getProperty("input.scan.processed.directory") + "/" + file.getName()));
		file.delete();
	}
	
}