package com.bloodnet.api.com.appconfig;

import java.util.Locale;
import java.util.TimeZone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


@Configuration 
@MapperScan("com.bloodnet.api.mappers")
public class WebConfig {
	
	/** アプリケーションのデフォルトロケール */
	public static final Locale APPLICATION_DEFAULT_LOCALE = Locale.JAPAN;
	
	/** アプリケーションのデフォルトタイムゾーン */
	public static final String APPLICATION_DEFAULT_TIMEZONE = "GMT-9:00";
	
	/** アプリケーションのアップロードファイルのデフォルトエンコーディング */
	public static final String APPLICATION_UPLOAD_DEFAULT_ENCODING = "UTF-8";
	
	/** アプリケーションのアップロードファイルのMAXサイズ */
	public static final int APPLICATION_UPLOAD_MAX_UPLOAD_SIZE = 32505856;
	
	/** files with size below this value are stored in memory, otherwise they will be stored in disk directly. */
	public static final int APPLICATION_UPLOAD_MAX_IN_MEMORY_SIZE = 4096;
	
//
//    private static final String RESOURCES_HANDLER = "/resources/";
//    private static final String RESOURCES_LOCATION = RESOURCES_HANDLER + "**";
	
//	@Bean(name = "validator")
//	public LocalValidatorFactoryBean validator() {
//	    LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
//	    validatorFactoryBean.setValidationMessageSource(messageSource());
//	    return validatorFactoryBean;
//	}
//	
//	@Override
//	public Validator getValidator() {
//	    return validator();
//	}
	
	@Bean(name = "messageSource")
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("i18n/messages");
	    messageSource.setDefaultEncoding("utf-8");
	    messageSource.setCacheSeconds(5);
	    return messageSource;
	}
//
//    @Override
//    public Validator getValidator() {
//        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//        validator.setValidationMessageSource(messageSource());
//        return validator;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
//    }
//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
    
    
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(APPLICATION_DEFAULT_LOCALE);
        TimeZone timezone = TimeZone.getTimeZone(APPLICATION_DEFAULT_TIMEZONE);
        resolver.setDefaultTimeZone(timezone);
        return resolver;
    }
    
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding(APPLICATION_UPLOAD_DEFAULT_ENCODING);
        resolver.setMaxUploadSize(APPLICATION_UPLOAD_MAX_UPLOAD_SIZE);
        resolver.setMaxInMemorySize(APPLICATION_UPLOAD_MAX_IN_MEMORY_SIZE);
        return resolver;
    }
    
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    //@Override
    //public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    //    registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
     //   registry.addResourceHandler("/favicon.ico").addResourceLocations("/assets/favicon.ico");
    //}
    



    

}