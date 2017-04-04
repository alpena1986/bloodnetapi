package com.bloodnet.api.controllers.com;


import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.LocaleResolver;

import com.bloodnet.api.com.annotation.WebAdminLogger;
import com.bloodnet.api.com.model.SystemUser;
import com.bloodnet.api.com.utils.BigDecimalUtils;



public class BaseController{

	/**
	 * ログイン中のユーザオブジェクト
	 */
	@Autowired
	protected SystemUser loggedInUser;
	

	
	@Autowired
	protected HttpSession session;
	
    @Autowired
    protected LocaleResolver localeResolver;
    
    @Autowired
    protected MessageSource messageSource;
	
    @Autowired
    protected BigDecimalUtils bigDecimalUtils;
    
    
	protected @WebAdminLogger Logger logger;
    
    protected DateTimeFormatter datepickerFormat = DateTimeFormat.forPattern("yyyy/MM/dd");

	public SystemUser getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(SystemUser loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	
}