package net.ua.configuration;

import net.ua.dao.*;
import net.ua.dao.realisation.*;
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

    @Bean
    public GroupDao groupDao() {
        return new GroupDaoImpl();
    }

    @Bean
    public StudentDao studentDao() {
        return new StudentDaoImpl();
    }

    @Bean
    public ActivityDao activityDao() {
        return new ActivityDaoImpl();
    }

    @Bean
    public CategoryDao categoryDao() {
        return new CategoryDaoImpl();
    }
}
