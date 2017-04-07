package com.bloodnet.api.com.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.WebContentInterceptor;



@Configuration
@EnableWebMvc
public class InterceptorConfig { 
    
    
    @Bean
    public MappedInterceptor WebContentInterceptor(){
        return new MappedInterceptor(null, new String[]{"/assets/**"}, getWebContentInterceptor());
    }
    
    @Bean
    public MappedInterceptor LocaleChangeInterceptor(){
        return new MappedInterceptor(null, new String[]{"/assets/**"}, getLocaleChangeInterceptor());
    }
   
    private LocaleChangeInterceptor getLocaleChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    private WebContentInterceptor getWebContentInterceptor(){
        WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
        webContentInterceptor.setCacheSeconds(0);
        webContentInterceptor.setUseExpiresHeader(true);
        webContentInterceptor.setUseCacheControlHeader(true);
        webContentInterceptor.setCacheControl(CacheControl.noStore());
        return new WebContentInterceptor();
    }
    

    
}
