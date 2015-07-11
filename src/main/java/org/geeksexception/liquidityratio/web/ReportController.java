package org.geeksexception.liquidityratio.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.geeksexception.liquidityratio.dao.MockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

@Controller
@RequestMapping(value = "/report")
public class ReportController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/report1", method=RequestMethod.GET)
	public ModelAndView generateLiquidityCoverageRatioReport(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Generating a Liquidity Coverage Ratio report");
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put(JasperReportsMultiFormatView.DEFAULT_FORMAT_KEY, "xls");
		model.put("datasource", new MockRepository().getDataSource());
		return new ModelAndView("liquidityCoverageRatioReport", model);
	}
}