package net.ua.configuration;

import net.ua.service.*;
import net.ua.service.realization.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public GroupService groupService() {
        return new GroupServiceImpl();
    }

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    public ActivityService activityService() {
        return new ActivityServiceImpl();
    }
}
