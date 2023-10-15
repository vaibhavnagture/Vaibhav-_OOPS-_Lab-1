package com.greatlearning.student.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.student.service.UserDetailsServiceImpl;

@Configuration
public class GLWebSecurityConfig extends WebSecurityConfigurerAdapter{
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(abc());
	}
	
	@Bean
	public DaoAuthenticationProvider abc()
	{
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		dao.setUserDetailsService(pqr());
		dao.setPasswordEncoder(lmn());
		return dao;
	}
	
	@Bean
	public UserDetailsService pqr()
	{
		return new UserDetailsServiceImpl();	
	}
	
	@Bean
	public BCryptPasswordEncoder lmn()
	{
        return new BCryptPasswordEncoder();
	}
	
	//Authorization
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/","/student/save","/student/showFormForAdd","/student/403","/student/welcome").hasAnyAuthority("USER","ADMIN")
            .antMatchers("/student/showFormForUpdate","/student/delete").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().loginProcessingUrl("/login").successForwardUrl("/student/list").permitAll()
            .and()
            .logout().logoutSuccessUrl("/login").permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/student/403")
            .and()
            .cors().and().csrf().disable();
    }



}
