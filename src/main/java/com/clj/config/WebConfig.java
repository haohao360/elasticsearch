package com.clj.config;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.clj.config.intercepors.LoginInterceptor;


@Configuration
public class WebConfig  implements WebMvcConfigurer {
	Logger logger = Logger.getLogger(WebConfig.class);
	
	
    @Autowired
    private LoginInterceptor loginInterceptor;
	// 这个方法是用来配置静态资源的，比如html，js，css，等等
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  
	  }
	 
	  // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
		    registry.addInterceptor(loginInterceptor).addPathPatterns("/project/*").excludePathPatterns("/").excludePathPatterns("/wechat/authorize").excludePathPatterns("/wechat/userInfo");
	  }
}
