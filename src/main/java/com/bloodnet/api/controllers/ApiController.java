package com.bloodnet.api.controllers;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.shiro.mgt.SecurityManager;

import com.bloodnet.api.controllers.com.BaseController;
import com.bloodnet.api.form.A00001Form;
import com.bloodnet.lib.Profile;

@RestController
public class ApiController extends BaseController {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

    @RequestMapping(value="/1", method=RequestMethod.GET)
    public Profile init(Model model, @ModelAttribute A00001Form form , HttpSession httpSession) throws Exception {
    	
        Factory<SecurityManager> factory =  new IniSecurityManagerFactory("classpath:shiro.ini");  
        SecurityManager securityManager = factory.getInstance();  
        SecurityUtils.setSecurityManager(securityManager);  
        Subject subject = SecurityUtils.getSubject();  
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
      
        try {  
            //4、登录，即身份验证  
            subject.login(token);  
        } catch (AuthenticationException e) {  
            //5、身份验证失败  
        }  
      
        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
      
        //6、退出  
        subject.logout();  
        
        
    	Profile p = new Profile();
    	p.setId("00001");
        return p;
    }
}