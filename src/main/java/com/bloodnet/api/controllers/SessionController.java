package com.bloodnet.api.controllers;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bloodnet.api.controllers.com.BaseController;
import com.bloodnet.api.model.TblUser;
import com.bloodnet.api.services.UserService;
import com.bloodnet.lib.Session;

@RestController
@RequestMapping("/sessions")
public class SessionController extends BaseController {
	
	@Autowired
	private UserService sessionService;

    @RequestMapping(value="", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String init(@RequestBody Session session) throws Exception {
    	TblUser user = sessionService.getUser(session.getUserId());
    	if (StringUtils.equals(session.getPassword(), user.getPassword())) {
    		return UUID.randomUUID().toString();
    	}
        return "";
    }
}