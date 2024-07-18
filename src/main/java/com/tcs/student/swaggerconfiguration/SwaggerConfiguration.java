package com.tcs.student.swaggerconfiguration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public GroupedOpenApi controllerApi()
	{
	        return GroupedOpenApi.builder()
	                .group("StudentManagement-Api")
	                .packagesToScan("com.tcs.student.controller") // Specify the package to scan
	                .build();
	 }


}
