package org.geeksexception.liquidityratio.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import org.geeksexception.liquidityratio.annotation.Development;

@Configuration
@EnableWebMvc
@Development
@ComponentScan(basePackages = "org.geeksexception.liquidityratio.web", excludeFilters = { @Filter(Configuration.class) })
public class DevelopmentWebMvcConfig extends AbstractWebMvcConfig {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/dist/**").addResourceLocations("/dist/");
		registry.addResourceHandler("/sitemap/**").addResourceLocations("/sitemap/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
		registry.addResourceHandler("/templates/**").addResourceLocations("/templates/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}
	
}