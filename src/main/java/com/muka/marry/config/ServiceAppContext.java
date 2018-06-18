package com.muka.marry.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.muka.marry.constants.UserRegistrationConstant;
import com.muka.marry.filter.SessionFilter;
import com.muka.marry.service.UserRegistrationService;
import com.muka.marry.service.impl.UserRegistrationServiceImpl;


@Configuration
//@PropertySource("classpath:application.properties")
public class ServiceAppContext {
	
	@Bean(name = UserRegistrationConstant.USER_REG_SERVICE)
	public UserRegistrationService getUserRegistrationService() {
		return new UserRegistrationServiceImpl();
	}

	// Register Filter
	@Bean
    public FilterRegistrationBean getSessionFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SessionFilter());
// In case you want the filter to apply to specific URL patterns only
       // registration.addUrlPatterns("/dawson/*");
        return registration;
    }
}
