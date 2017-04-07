package com.bloodnet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bloodnet.api.controllers.com.BaseController;
import com.bloodnet.api.services.AcidService;
import com.bloodnet.api.services.UserService;
import com.bloodnet.lib.User;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private AcidService acidService;
	
    @RequestMapping(value="", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void init(@RequestBody User user) throws Exception {
    	userService.createUser(user);
    }
}