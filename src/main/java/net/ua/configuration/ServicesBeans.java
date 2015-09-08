package net.ua.configuration;

import net.ua.service.EmployeeService;
import net.ua.service.realization.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesBeans {

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl();
    }
}
