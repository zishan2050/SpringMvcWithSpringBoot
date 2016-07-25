package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.demo.model.CalculationHelper;
import com.demo.model.CalculationModeHelper;
import com.demo.model.OffenceHelper;
import com.demo.model.StudentHelper;

@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/views/");
        resolver.setSuffix(".html");
        return resolver;
    }
    
    @Bean
    public CalculationHelper calculate(){
    	return new CalculationHelper();
    }
    
    @Bean
    public OffenceHelper offence(){
    	return new OffenceHelper();
    }
    
    @Bean
    public StudentHelper studentHelper(){
    	return new StudentHelper();
    }
    
    @Bean
    public CalculationModeHelper calculationModeHelper(){
    	return new CalculationModeHelper();
    }
}
