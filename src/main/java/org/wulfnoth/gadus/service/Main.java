package org.wulfnoth.gadus.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.wulfnoth.gadus.service.entity.ConfigEntity;

@SpringBootApplication
public class Main {

	public static ConfigEntity config;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
		config = ctx.getBean(ConfigEntity.class);

	}

}
