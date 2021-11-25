package com.ryanaubrey.configuration;

import com.ryanaubrey.configuration.autowire.AutowireDIConfig;
import com.ryanaubrey.configuration.autowire.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationApplication.class, args);

		ManualDIConfig.Store s = new ManualDIConfig().store();
		System.out.println(String.format("MANUAL: We have a store of %d items.", s.getItems().size()));

		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.ryanaubrey.configuration");
		appContext.refresh();

		AutowireDIConfig config = appContext.getBean(AutowireDIConfig.class);
		User u = config.userService().getUserByName("Ryan Aubrey");
		System.out.println(u.toString());

		appContext.close();
	}

}
