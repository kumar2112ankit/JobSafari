package com.jobSafari.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwegerConfugration {
	@Bean
	public Docket sewggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(PathSelectors.ant("/api/*")).apis(RequestHandlerSelectors.basePackage("com.jobSafari"))
				.build();
				
	}
}