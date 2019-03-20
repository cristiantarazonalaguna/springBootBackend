package com.intercorp.cliente.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@Import(SwaggerConfig.class)
public class AppPrueba implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(AppPrueba.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
	}

}
