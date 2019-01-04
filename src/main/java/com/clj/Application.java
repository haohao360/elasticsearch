package com.clj;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	/*
	 * public static void main(String[] args) {
	 * SpringApplication.run(XiaoquApplication.class, args); }
	 */

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		logger.info("=====XiaoquApplication开始启动======");
		return application.sources(Application.class);
	}
}
