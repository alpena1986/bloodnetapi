package com.bloodnet.bloodnetapi.com.appconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration

//To enable MVC Java config add the annotation @EnableWebMvc to one of your @Configuration classes
//@EnableWebMvc  

//@ComponentScan


@EnableAspectJAutoProxy
@ComponentScan( basePackages = {"com.bloodnet.bloodnetapi"} )
@ImportResource("classpath:spring-mvc.xml")
public class RootConfig  extends WebMvcConfigurationSupport{

}