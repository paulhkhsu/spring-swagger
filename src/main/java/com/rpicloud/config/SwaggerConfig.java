package com.rpicloud.config;

import static springfox.documentation.builders.PathSelectors.*;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@SwaggerDefinition(
//		info=@Info(description="Finicity's ACH Account Verification service includes service for downloading ACH data for customer accounts.",
//		 title="Finicity API - ACH Account Verification",
//		 version="1.0.0"
//		 )
//		, basePath="/",
//		host="localhost:8080",
//		schemes = {SwaggerDefinition.Scheme.HTTPS})
public class SwaggerConfig {
	// @Bean
	// public Docket productApi() {
	// return new Docket(DocumentationType.SWAGGER_2)
	// .select()
	// .apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
	// .paths(regex("/product.*"))
	// .build()
	// .apiInfo(metaData());
	// }
	// private ApiInfo metaData() {
	// ApiInfo apiInfo = new ApiInfo(
	// "Spring Boot REST API",
	// "Spring Boot REST API for Demo",
	// "1.0",
	// "Terms of service",
	// new Contact("Paul Hsu", "https://springframework.guru/about/",
	// "paul@gmail.com"),
	// "Apache License Version 2.0",
	// "https://www.apache.org/licenses/LICENSE-2.0");
	// return apiInfo;
	// }

	// @Bean
	// public Docket newsApi() {
	// // return new
	// //
	// Docket(DocumentationType.SWAGGER_2).groupName("demo").apiInfo(apiInfo()).select()
	// // .paths(ant("/pies.*")).paths(paths()).build();
	// return new
	// Docket(DocumentationType.SWAGGER_2).groupName("pie").apiInfo(apiInfo()).select()
	// .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();
	// }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Finicity API - ACH Account Verification")
				.description("Finicity's ACH Account Verification service includes service for " +
				"downloading ACH data for customer accounts " +
						" next line end.")
				.version("1.0.0")
				.build();
	}

	private Set<String> protocols() {
		Set<String> set = new HashSet<>();
		set.add("http");
		return set;
	}
	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2)
	//			.host("stg-us-api.experian.com")
				.host("localhost:8080")
				//.groupName("demo")
				.protocols(protocols())
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(PathSelectors.any())
				.build().pathMapping("/");
	}
}
