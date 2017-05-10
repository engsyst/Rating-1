package ua.nure.indplan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ua.nure.indplan.configuration.StorageProperties;
import ua.nure.indplan.service.StorageService;

@SpringBootApplication
// @EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@EnableConfigurationProperties(StorageProperties.class)
@ComponentScan("ua.nure.indplan")
public class RatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}
}
