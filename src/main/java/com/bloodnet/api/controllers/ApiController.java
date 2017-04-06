package com.bloodnet.api.controllers;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bloodnet.api.controllers.com.BaseController;
import com.bloodnet.api.form.A00001Form;
import com.bloodnet.lib.Profile;

@RestController
public class ApiController extends BaseController {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    @RequestMapping(value="/1", method=RequestMethod.GET)
    public Profile init(Model model, @ModelAttribute A00001Form form , HttpSession httpSession) throws Exception {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("12345", "12345");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        subject.logout();
        
    	Profile p = new Profile();
    	p.setId("00001");
        return p;
    }
}