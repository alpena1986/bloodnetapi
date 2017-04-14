package com.bloodnet.api.controllers;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bloodnet.api.com.exception.BadRequestException;
import com.bloodnet.api.controllers.com.BaseController;
import com.bloodnet.api.services.AcidAPIService;
import com.bloodnet.api.services.ProfileAPIService;
import com.bloodnet.lib.Profile;
import com.bloodnet.lib.RestResponseBody;

@RestController
@RequestMapping("/profiles")
public class ProfileAPIController extends BaseController {
	
	@Autowired
	private ProfileAPIService profileService;

	@Autowired
	private AcidAPIService acidService;
	
    @RequestMapping(value="", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RestResponseBody post(@RequestBody Profile profile) {
    	
    	if (StringUtils.isBlank(profile.getSex()) ||
    			StringUtils.isBlank(profile.getFamilyName()) ||
    			StringUtils.isBlank(profile.getFirstName()) ||
    			StringUtils.isBlank(profile.getBirthYear())){
    		throw new BadRequestException();
    	}
    	profileService.createProfile(profile);
    	return RestResponseBody.SUCCESS;
    	
    }
    
    @RequestMapping(value="", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void get() {
    	
    	//profileService.createProfile(profile);
    }
}