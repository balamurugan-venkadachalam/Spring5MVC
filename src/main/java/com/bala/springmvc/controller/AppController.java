package com.bala.springmvc.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bala.springmvc.error.OrderNotFoundException;

@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = { "/tilesDef" }, method = RequestMethod.GET)
	public String test(ModelMap model) {
		return "baseLayout";
	}

	@RequestMapping(value = { "/template" }, method = RequestMethod.GET)
	public String tiles(ModelMap model) {
		return "tile_template";
	}

	@RequestMapping(value = { "/error" }, method = RequestMethod.GET)
	public String throwError(ModelMap model) {
		throw new NullPointerException();

		// return "tile_template";
	}

	@RequestMapping(value = { "/order/{orderId}" }, method = RequestMethod.GET)
	public String fatchOrder(ModelMap model, @PathVariable(name = "orderId") Long orderId) throws SQLException {

		if (orderId == 100l) {
			throw new OrderNotFoundException();
		}
		if (orderId == 1000l) {
			throw new SQLException();
		}
		if (orderId == 1002l) {
			throw new NumberFormatException();
		}
		model.addAttribute("order", "Your Order Id Is " + orderId);

		return "success";
	}

	@ExceptionHandler({ SQLException.class })
	public ModelAndView databaseError() {
		Map<String, String> errors = new HashMap<>();
		errors.put("database error", "SQL Exception");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errors", errors);
		modelAndView.setViewName("error");
		return modelAndView;
	}
	
	


	

}