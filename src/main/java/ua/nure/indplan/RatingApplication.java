package ua.nure.indplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@ComponentScan("ua.nure.indplan")
public class RatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingApplication.class, args);
	}
}
