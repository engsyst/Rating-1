package net.ua.configuration;

import net.ua.dao.EmployeeDAO;
import net.ua.dao.realisation.EmployeeDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoBeans {

    @Bean
    public EmployeeDAO employeeDAO() {
        return new EmployeeDAOImpl();
    }
}
