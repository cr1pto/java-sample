package com.example.cr1pto.sampleweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SamplewebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamplewebApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Applies to all endpoints
						.allowedOrigins(
							"http://localhost:5173", 
							"http://localhost:3000",
							"https://localhost:3000",
							"http://localhost:4200",
							"https://localhost:4200",
						"http://allowed-origin-2.com") // Whitelist specific
																								// origins
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
						.allowedHeaders("*") // Allows all headers
						.allowCredentials(true) // Allows sending credentials like cookies
						.maxAge(3600); // Cac
			}
		};
	}

}
