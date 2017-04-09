package com.bloodnet.api.controllers;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bloodnet.api.com.exception.BadRequestException;
import com.bloodnet.api.com.exception.UserAlreadyExistsException;
import com.bloodnet.api.com.exception.UserNotFoundException;
import com.bloodnet.api.controllers.com.BaseController;
import com.bloodnet.api.services.AcidAPIService;
import com.bloodnet.api.services.UserAPIService;
import com.bloodnet.lib.User;

@RestController
@RequestMapping("/users")
public class UserAPIController extends BaseController {
	
	@Autowired
	private UserAPIService userService;

	@Autowired
	private AcidAPIService acidService;
	
	/**
	 * 创建一个用户
	 * @param user 用户的各种信息
	 * @throws Exception
	 */
    @RequestMapping(value="", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void post(@RequestBody User user) throws Exception {
    	try{
    		userService.createUser(user);
    	}catch (DuplicateKeyException ex) {
    		throw new UserAlreadyExistsException(user.getId());
    	}
    }
  
    /**
     * 获取一个已经存在的用户
     */
    @RequestMapping(value="/{id}", method=RequestMethod.GET,  consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable String id) throws Exception {
    	String userId = "asdffds";
    	if (StringUtils.isBlank(userId)) {
    		throw new BadRequestException();
    	}
    	User user = userService.getUser(userId);
    	if(user == null){
    		throw new UserNotFoundException(userId);
    	}
    	return user;
    }
}