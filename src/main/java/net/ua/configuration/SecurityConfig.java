package net.ua.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.antMatchers("/").permitAll()
            	.antMatchers("/student/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/error/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/font-awesome/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(UserDetailsService userDetailsService, AuthenticationManagerBuilder auth) throws Exception {
        auth
        .inMemoryAuthentication()
        .withUser("gifton12").password("123456").roles("admin");
    }
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//@Configuration
//@EnableWebSecurity
////@ComponentScan(basePackageClasses = net.ua.service.realization.UserServiceImpl.class)
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	BCryptPasswordEncoder bcryptEncoder;
//
//	@Autowired
//	public void configureGlobal(UserDetailsService userDetailsService, AuthenticationManagerBuilder auth)
//			throws Exception {
//		auth.userDetailsService(userDetailsService);
//		.passwordEncoder(bcryptEncoder)
//	}
//
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/error/**").permitAll()
//                .antMatchers("/static/**").permitAll()
//                .anyRequest().authenticated();
//                .and()
//                .formLogin()
//                .loginPage("/sign-in")
//                .defaultSuccessUrl("/account")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/j_spring_security_logout"))
//                .logoutSuccessUrl("/")
//                .permitAll()
//                .and()
//                .rememberMe();
//
//        http.sessionManagement()
//                .sessionFixation()
//                .newSession();
//    }
//
//	@Bean
//	public BCryptPasswordEncoder encoder() {
//		return new BCryptPasswordEncoder(12);
//	}
//}
