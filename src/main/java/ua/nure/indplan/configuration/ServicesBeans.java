package ua.nure.indplan.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.nure.indplan.service.ActivityService;
import ua.nure.indplan.service.CategoryService;
import ua.nure.indplan.service.CategoryTypeService;
import ua.nure.indplan.service.EmployeeService;
import ua.nure.indplan.service.RoleService;
import ua.nure.indplan.service.UserService;
import ua.nure.indplan.service.WorkService;
import ua.nure.indplan.service.WorkTypeService;
import ua.nure.indplan.service.realization.ActivityServiceImpl;
import ua.nure.indplan.service.realization.CategoryServiceImpl;
import ua.nure.indplan.service.realization.CategoryTypeFormatter;
import ua.nure.indplan.service.realization.CategoryTypeServiceImpl;
import ua.nure.indplan.service.realization.DateFormatter;
import ua.nure.indplan.service.realization.EmployeeFormatter;
import ua.nure.indplan.service.realization.EmployeeServiceImpl;
import ua.nure.indplan.service.realization.RoleFormatter;
import ua.nure.indplan.service.realization.RoleServiceImpl;
import ua.nure.indplan.service.realization.UserServiceImpl;
import ua.nure.indplan.service.realization.WorkServiceImpl;
import ua.nure.indplan.service.realization.WorkTypeFormatter;
import ua.nure.indplan.service.realization.WorkTypeServiceImpl;

@Configuration
public class ServicesBeans {

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
    
    @Bean
    public RoleService roleService() {
        return new RoleServiceImpl();
    }

    @Bean
    public ActivityService activityService() {
        return new ActivityServiceImpl();
    }

    @Bean
    public CategoryService categoryService() {
        return new CategoryServiceImpl();
    }
    
    @Bean
    public CategoryTypeService categoryTypeService() {
    	return new CategoryTypeServiceImpl();
    }
    
    @Bean
    public CategoryTypeFormatter categoryTypeFormatter() {
    	return new CategoryTypeFormatter();
    }
    
    @Bean
    public WorkService workService() {
    	return new WorkServiceImpl();
    }
    
    @Bean
    public WorkTypeService workTypeService() {
    	return new WorkTypeServiceImpl();
    }
    
    @Bean
    public WorkTypeFormatter workTypeFormatter() {
    	return new WorkTypeFormatter();
    }
    
    @Bean
    public RoleFormatter roleFormatter() {
    	return new RoleFormatter();
    }
    
    @Bean
    public DateFormatter dateFormatter() {
    	return new DateFormatter();
    }
    
    @Bean
    public EmployeeFormatter employeeFormatter() {
    	return new EmployeeFormatter();
    }
    
/*    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
*/}
