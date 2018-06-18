package com.muka.marry;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
@EnableAutoConfiguration
//@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages={"com.muka.marry"})
//@PropertySource("classpath:application.properties")
//@PropertySource("classpath:email.properties")

@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:email.properties")
})
//@EnableAutoConfiguration
public class MarrycallApplication {
	private static Logger logger=Logger.getLogger(MarrycallApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarrycallApplication.class, args);
		logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
        logger.fatal("Damn! Fatal error. Please fix me.");
		
	}
}
