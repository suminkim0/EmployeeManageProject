package com.thym.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thym.dto.EmployeeDTO;
import com.thym.service.EmployeeService;

@Controller
public class MainController {

	private EmployeeService service;

	public MainController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping("/main")
	public ModelAndView main(ModelAndView view) {
		List<EmployeeDTO> list = service.selectAllEmployee();
		view.addObject("list",list);
		view.setViewName("main");
		return view;
	}
	
}
