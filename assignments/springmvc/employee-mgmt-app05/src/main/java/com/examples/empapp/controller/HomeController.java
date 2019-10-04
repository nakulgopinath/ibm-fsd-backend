package com.examples.empapp.controller;



import com.examples.empapp.model.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@ModelAttribute("employee")
	public Employee createEmployeeModel() {
		// ModelAttribute value should be same as used in the empSave.jsp
		return new Employee();
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public  ModelAndView home(Locale locale, Model model) {
				
		ModelAndView modelView = new ModelAndView("home");
		
		return modelView;
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployeePage(Model model) {
		
		ModelAndView modelView = new ModelAndView("addEmployee");
		return modelView;
	
	}
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public ModelAndView viewEmployeePage(Model model) {
		ModelAndView modelView = new ModelAndView("viewEmployee");
		return modelView;
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public ModelAndView updateEmployeePage(Model model) {
		ModelAndView modelView = new ModelAndView("updateEmployee");
		return modelView;
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployeePage(Model model) {
		ModelAndView modelView = new ModelAndView("deleteEmployee");
		return modelView;
	}
}

