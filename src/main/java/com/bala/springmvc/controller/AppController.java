package com.bala.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = { "/tilesDef"}, method = RequestMethod.GET)
	public String test(ModelMap model) {
		return "baseLayout";
	}

	@RequestMapping(value = { "/template"}, method = RequestMethod.GET)
	public String tiles(ModelMap model) {
		return "tile_template";
	}
}