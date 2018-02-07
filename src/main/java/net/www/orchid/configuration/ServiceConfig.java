package net.www.orchid.configuration;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan({"net.www.orchid.listener",
				"net.www.orchid.controller",
				"net.www.orchid.service.impl", 
				"net.www.orchid.component.impl"})
@EnableAspectJAutoProxy
public class ServiceConfig {

	@Bean
	public PropertiesFactoryBean properties(){
		PropertiesFactoryBean properties = new PropertiesFactoryBean();
		properties.setLocations(new ClassPathResource("logic.properties"));
		return properties;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() throws IOException {
		PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
		conf.setLocations(new ClassPathResource("logic.properties")
						, new ClassPathResource("properties/application.properties")
						, new ClassPathResource("properties/elasticsearch.properties"));
		return conf;
	}
}
