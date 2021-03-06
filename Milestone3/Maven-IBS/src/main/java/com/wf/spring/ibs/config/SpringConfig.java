package com.wf.spring.ibs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc // initiate bean factory auto 
@ComponentScan("com.wf.spring.ibs")
public class SpringConfig implements WebMvcConfigurer {

	// method to expose ViewResolver Bean
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver =
				new InternalResourceViewResolver();
		// inject dependency
		viewResolver.setPrefix("/WEB-INF/views/jsp/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
