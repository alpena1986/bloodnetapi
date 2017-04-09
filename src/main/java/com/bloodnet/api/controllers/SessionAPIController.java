package com.bloodnet.api.controllers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bloodnet.api.controllers.com.BaseController;
import com.bloodnet.api.services.AcidAPIService;
import com.bloodnet.api.services.UserAPIService;
import com.bloodnet.lib.Session;

@RestController
@RequestMapping("/sessions")
public class SessionAPIController extends BaseController {
	
	@Autowired
	private UserAPIService sessionService;

	@Autowired
	private AcidAPIService acidService;
	
    @RequestMapping(value="", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String init(@RequestBody Session session) throws Exception {
    	
		UsernamePasswordToken token = new UsernamePasswordToken(session.getUserId(), session.getPassword());
		final Subject subject = SecurityUtils.getSubject();
		try{
			subject.login(token);
			return acidService.createAcid(session.getUserId());
		}catch(AuthenticationException e){
			return "";
		}
    }
}