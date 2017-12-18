package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Users;
import com.servicesapi.UsersService;

@Controller
@RequestMapping("users")
public class UsersController {
	final static Logger logger=Logger.getLogger(UsersController.class);
	
	@Autowired
	UsersService userServices;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView view = new ModelAndView("users");
		return view;
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)

	public @ResponseBody Map<String, Object> getSaved(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userServices.saveOrUpdate(users)) {
		
			map.put("status", "200");
			map.put("message", "Your record have been saved successfully");
		} if(! userServices.saveOrUpdate(users)){
			
			map.put("status", "1062 user-Login Or email already exit");
			map.put("message", "user-Login Or email already exit");
		}
		

		return map;
	}
	
	
	
	@RequestMapping(value = "/resultcount", method = RequestMethod.POST)

	public @ResponseBody Map<String, Object> getAll(Users users) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Users> resultcount = userServices.resultcount();

		if (resultcount != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", resultcount);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found");

		}

		return map;
	}
	

	@RequestMapping(value = "/list", method = RequestMethod.POST)

	public @ResponseBody Map<String, Object> getAll(Users users, @RequestParam("firstresult") int firstresult) {

		System.out.println("------------" + firstresult);

		Map<String, Object> map = new HashMap<String, Object>();

		List<Users> list = userServices.list(firstresult);

		if (list != null) {
			map.put("status", "200");
			map.put("message", "Data found");
			map.put("data", list);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found");

		}

		return map;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(Users users) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (userServices.delete(users)) {
			map.put("status", "200");
			map.put("message", "Your record have been deleted successfully");
		}

		return map;
	}
}