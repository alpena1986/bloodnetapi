package com.bloodnet.bloodnetapi.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bloodnet.bloodnetapi.controllers.com.BaseController;
import com.bloodnet.bloodnetapi.form.A00001Form;
import com.bloodnet.bloodnetapi.services.A00001Service;



@Controller
public class A00001Controller extends BaseController {
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private A00001Service a00001Service;
	
    @RequestMapping(value="/1", method=RequestMethod.GET)
    public String init(Model model, @ModelAttribute A00001Form form , HttpSession httpSession) throws Exception {
    	
        return "A00001";
    }
    
    @RequestMapping(value="/1/register", method=RequestMethod.POST)
    public String register(Model model,@ModelAttribute A00001Form form ,HttpSession httpSession) throws Exception {
    	
    	model.addAttribute("message", "登录成功");
        return "A00001";
    }
}