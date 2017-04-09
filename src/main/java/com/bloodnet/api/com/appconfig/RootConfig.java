package com.bloodnet.api.com.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


@Configuration

//To enable MVC Java config add the annotation @EnableWebMvc to one of your @Configuration classes
//@EnableWebMvc  

//@ComponentScan
@EnableAspectJAutoProxy
@ComponentScan( basePackages = {"com.bloodnet.api"} )
@ImportResource("classpath:spring-mvc.xml")
public class RootConfig extends WebMvcConfigurerAdapter {
	
    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
        // Turn off suffix-based content negotiation
        //configurer.favorPathExtension(false);
        //configurer.favorParameter(false);
        //configurer.useJaf(false);
        //configurer.defaultContentType(MediaType.APPLICATION_JSON);
        configurer.mediaType("com", MediaType.APPLICATION_JSON);
        
        /*
         *So what happens is that Spring is trying to present the result to in a content type it can't find a converter to.
         *To solve this you need to tell spring to turn off suffix-based content negotiation 
         *what's happening is likely that the Java Activation Framework is recognising some of your suffixes
         *and returning a media type for them 
         * - the .c extension probably returns text/x-c since that's causing an exception.
         */
    }
    
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
    	RequestMappingHandlerMapping req = new RequestMappingHandlerMapping();
    	req.setUseRegisteredSuffixPatternMatch(false);
    	req.setUseSuffixPatternMatch(false);
    	return req;
    }
    
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
	      // turn off all suffix pattern matching
	      configurer.setUseSuffixPatternMatch(false);
	      // OR
	      // turn on suffix pattern matching ONLY for suffixes
	      // you explicitly register using
	      // configureContentNegotiation(...)
	      configurer.setUseRegisteredSuffixPatternMatch(false);
	}

}