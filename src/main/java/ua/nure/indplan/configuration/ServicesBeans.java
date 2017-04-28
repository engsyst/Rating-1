package ua.nure.indplan.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import ua.nure.indplan.service.ActivityService;
import ua.nure.indplan.service.CategoryService;
import ua.nure.indplan.service.CategoryTypeService;
import ua.nure.indplan.service.EmployeeService;
import ua.nure.indplan.service.RoleService;
import ua.nure.indplan.service.UserService;
import ua.nure.indplan.service.realization.ActivityServiceImpl;
import ua.nure.indplan.service.realization.CategoryServiceImpl;
import ua.nure.indplan.service.realization.CategoryTypeFormatter;
import ua.nure.indplan.service.realization.CategoryTypeServiceImpl;
import ua.nure.indplan.service.realization.EmployeeFormatter;
import ua.nure.indplan.service.realization.EmployeeServiceImpl;
import ua.nure.indplan.service.realization.RoleFormatter;
import ua.nure.indplan.service.realization.RoleServiceImpl;
import ua.nure.indplan.service.realization.UserServiceImpl;

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
    public RoleFormatter roleFormatter() {
    	return new RoleFormatter();
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
