package com.wf.bootapp.ibs.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder builder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(builder.username("1111111111111112").password("user").roles("USER"))
				.withUser(builder.username("admin").password("admin").roles("ADMIN"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests() 
		
				.antMatchers("/user/**").hasRole("USER").antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/css/**").permitAll()
				.antMatchers("/images/**").permitAll()
				.antMatchers("/newregistration").permitAll()
				.antMatchers("/UnregisteredCust").permitAll()
				
				.anyRequest()				
				.authenticated().and().formLogin().loginPage("/login-form").loginProcessingUrl("/validate").permitAll()
				.and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");

	}
}
