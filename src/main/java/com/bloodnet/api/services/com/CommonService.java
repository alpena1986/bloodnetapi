package com.bloodnet.api.services.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class CommonService{

    @Autowired
    protected MessageSource messageSource;
    
 
}