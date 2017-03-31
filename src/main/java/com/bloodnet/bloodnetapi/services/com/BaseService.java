package com.bloodnet.bloodnetapi.services.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.bloodnet.bloodnetapi.com.utils.BigDecimalUtils;




@Service
public class BaseService{

    @Autowired
    protected BigDecimalUtils bigDecimalUtils;
    
    @Autowired
    protected MessageSource messageSource;
}
