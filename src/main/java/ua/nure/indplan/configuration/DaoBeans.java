package ua.nure.indplan.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.nure.indplan.dao.ActivityDao;
import ua.nure.indplan.dao.CategoryDao;
import ua.nure.indplan.dao.CategoryTypeDao;
import ua.nure.indplan.dao.EmployeeDAO;
import ua.nure.indplan.dao.RoleDao;
import ua.nure.indplan.dao.UserDao;
import ua.nure.indplan.dao.WorkDao;
import ua.nure.indplan.dao.WorkTypeDao;
import ua.nure.indplan.dao.realisation.ActivityDaoImpl;
import ua.nure.indplan.dao.realisation.CategoryDaoImpl;
import ua.nure.indplan.dao.realisation.CategoryTypeDaoImpl;
import ua.nure.indplan.dao.realisation.EmployeeDAOImpl;
import ua.nure.indplan.dao.realisation.RoleDaoImpl;
import ua.nure.indplan.dao.realisation.UserDaoImpl;
import ua.nure.indplan.dao.realisation.WorkDaoImpl;
import ua.nure.indplan.dao.realisation.WorkTypeDaoImpl;

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
    public ActivityDao activityDao() {
        return new ActivityDaoImpl();
    }

    @Bean
    public CategoryDao categoryDao() {
        return new CategoryDaoImpl();
    }
    
    @Bean
    public CategoryTypeDao categoryTypeDao() {
    	return new CategoryTypeDaoImpl();
    }
    
    @Bean
    public WorkDao workDao() {
    	return new WorkDaoImpl();
    }
    
    @Bean
    public WorkTypeDao workTypeDao() {
    	return new WorkTypeDaoImpl();
    }
}
