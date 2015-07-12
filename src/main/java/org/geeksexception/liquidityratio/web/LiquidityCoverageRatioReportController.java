package org.geeksexception.liquidityratio.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.geeksexception.liquidityratio.model.LiquidityCoverageRatio;
import org.geeksexception.liquidityratio.service.LiquidityCoverageRatioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

@Controller
@RequestMapping(value = "/lcr")
public class LiquidityCoverageRatioReportController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private @Inject LiquidityCoverageRatioService liquidityCoverageRatioService;
	
	@RequestMapping(value="/{id}/{format}", method=RequestMethod.GET)
	public ModelAndView generateLiquidityCoverageRatioReport(@PathVariable Long id, @PathVariable String format, HttpServletResponse response) {
		logger.info("Generating a Liquidity Coverage Ratio report for {}", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		//String fileName = "LCR-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "." + format;
		//logger.info(fileName);
		//response.setHeader("Content-disposition", "attachment; \"filename=" + fileName + "\"");
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(JasperReportsMultiFormatView.DEFAULT_FORMAT_KEY, format);
		List<LiquidityCoverageRatio> liquidityCoverageRatios = new ArrayList<LiquidityCoverageRatio>();
		LiquidityCoverageRatio liquidityCoverageRatio = liquidityCoverageRatioService.findLiquidityCoverageRatio(id);
		if(liquidityCoverageRatio != null) liquidityCoverageRatios.add(liquidityCoverageRatio);
		model.put("liquidityCoverageRatio", liquidityCoverageRatios);
		
		return new ModelAndView("liquidityCoverageRatioReport", model);
	}
}