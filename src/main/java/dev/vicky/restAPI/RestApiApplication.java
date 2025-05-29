package dev.vicky.restAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;


@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/cloudvendor/*")).apis(RequestHandlerSelectors.basePackage("dev.vicky.restAPI")).build().apiInfo(apiCustomData());
	}


	private ApiInfo apiCustomData(){
		return new ApiInfo(
				"Cloud Vendor API",
				"Cloud Vendor Documentation",
				"1.1",
				"CloudVendor Service Terms",
				new Contact("Vicky kumar","http://vickyjnv.github.io","vickywork2025@gmail.com"),
				"vicky license",
				"http://vickyjnv.github.io",
				Collections.emptyList()
		);

	}
}

