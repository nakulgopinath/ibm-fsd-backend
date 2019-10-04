package com.examples.empapp.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;



@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	

	
	@ModelAttribute("employee")
	public Employee createEmployeeModel() {
		return new Employee();
	}
	
	
	
	@RequestMapping(value = "addEmployee.do", method = RequestMethod.POST)
	public String saveEmployeeAction(@ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
//			logger.info("Returning empSave.jsp page");
			return "addEmployee";
		}
		
//		logger.info("Returning empSaveSuccess.jsp page");
		System.out.println(employee.getId());
		model.addAttribute("emp", employee);
	
		empService.addEmployee(employee);
		return "addEmployeeAlert";
	}
	
	@RequestMapping(value= "viewEmployee.do",method = RequestMethod.POST)
	public String viewEmployeeAction(@ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
//			logger.info("Returning empSave.jsp page");
			return "viewEmployee";
		}
//		logger.info("Returning empSaveSuccess.jsp page");
		System.out.println(employee.getId());
		

		employee =empService.viewEmployee(employee.getId());
		model.addAttribute("emp", employee);
		return "viewEmployeeAlert";
	}
	
	
	@RequestMapping(value= "updateEmployee.do",method = RequestMethod.POST)
	public String updateEmployeeAction(@ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
//			logger.info("Returning empSave.jsp page");
			return "updateEmployee";
		}
//	
		model.addAttribute("emp", employee);
		empService.updateEmployee(employee);;
		return "updateEmployeeAlert";
	}
	
	@RequestMapping(value= "deleteEmployee.do",method = RequestMethod.POST)
	public String deleteEmployeeAction(@ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
//			logger.info("Returning empSave.jsp page");
			return "deleteEmployee";
		}
//	
		model.addAttribute("emp", employee);
		empService.deleteEmployee(employee.getId());
		return "deleteEmployeeAlert";
	}
	
	@RequestMapping(value= "listAllEmployees.do",method = RequestMethod.POST)
	public String viewAllEmployeeAction(@ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
//			logger.info("Returning empSave.jsp page");
			return "/";
		}
//	
		

		ArrayList <Employee > eList =empService.viewAllEmployee();
		model.addAttribute("employees", eList);
		return "viewAllEmployees";
	}
	
}
