package org.geeksexception.liquidityratio.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("org.geeksexception.liquidityratio.service")
public class ServiceConfig {
	
}