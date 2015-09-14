package net.ua.configuration;

import net.ua.service.EmployeeService;
import net.ua.service.GroupService;
import net.ua.service.RoleService;
import net.ua.service.UserService;
import net.ua.service.realization.EmployeeServiceImpl;
import net.ua.service.realization.GroupServiceImpl;
import net.ua.service.realization.RoleServiceImpl;
import net.ua.service.realization.UserServiceImpl;
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
}
