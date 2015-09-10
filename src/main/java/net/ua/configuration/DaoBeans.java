package net.ua.configuration;

import net.ua.dao.EmployeeDAO;
import net.ua.dao.RoleDao;
import net.ua.dao.UserDao;
import net.ua.dao.realisation.EmployeeDAOImpl;
import net.ua.dao.realisation.RoleDaoImpl;
import net.ua.dao.realisation.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoBeans {

    @Bean
    public EmployeeDAO employeeDAO() {
        return new EmployeeDAOImpl();
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    @Bean
    public RoleDao roleDao() {
        return new RoleDaoImpl();
    }
}
