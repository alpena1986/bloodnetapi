package com.bloodnet.bloodnetapi.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bloodnet.bloodnetapi.controllers.com.BaseController;
import com.bloodnet.bloodnetapi.form.A00001Form;
import com.bloodnet.bloodnetapi.services.A00001Service;
import com.bloodnet.lib.Profile;

@RestController
public class SystemUserController extends BaseController {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private A00001Service a00001Service;

    @RequestMapping(value="/1", method=RequestMethod.GET)
    public Profile init(Model model, @ModelAttribute A00001Form form , HttpSession httpSession) throws Exception {
    	Profile p = new Profile();
    	p.setId("00001");
        return p;
    }
}