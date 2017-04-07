package com.bloodnet.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bloodnet.api.controllers.com.BaseController;
import com.bloodnet.api.services.AcidService;
import com.bloodnet.api.services.ProfileService;
import com.bloodnet.lib.Profile;

@RestController
@RequestMapping("/profiles")
public class ProfileController extends BaseController {
	
	@Autowired
	private ProfileService profileService;

	@Autowired
	private AcidService acidService;
	
    @RequestMapping(value="", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void init(@RequestBody Profile profile) {
    	
    	profileService.createProfile(profile);
 
    }
}