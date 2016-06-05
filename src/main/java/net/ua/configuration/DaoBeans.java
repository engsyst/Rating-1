package net.ua.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.ua.dao.ActivityDao;
import net.ua.dao.CategoryDao;
import net.ua.dao.EmployeeDAO;
import net.ua.dao.GroupDao;
import net.ua.dao.RoleDao;
import net.ua.dao.StudentDao;
import net.ua.dao.UserDao;
import net.ua.dao.realisation.ActivityDaoImpl;
import net.ua.dao.realisation.CategoryDaoImpl;
import net.ua.dao.realisation.EmployeeDAOImpl;
import net.ua.dao.realisation.GroupDaoImpl;
import net.ua.dao.realisation.RoleDaoImpl;
import net.ua.dao.realisation.StudentDaoImpl;
import net.ua.dao.realisation.UserDaoImpl;

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
