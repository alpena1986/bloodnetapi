package com.bloodnet.api.com.appconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.bloodnet.api.com.model.SystemUser;
import com.bloodnet.api.com.utils.BigDecimalUtils;
import com.bloodnet.api.services.com.CommonService;

@Configuration
public class SessionConfig  extends WebMvcConfigurationSupport{

    @Autowired
    private CommonService commonService;
	
    @Bean(name = "loggedInUser")
    public SystemUser loggedInUser(){
        return new SystemUser();
    }
   
    @Bean 
    public BigDecimalUtils bigDecimalUtils(){
        return new BigDecimalUtils();
    }
}