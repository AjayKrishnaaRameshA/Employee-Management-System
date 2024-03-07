package com.employee.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.employee.demo.model.Employee;
import com.employee.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		 model.addAttribute("empList",service.showAllEmployees());
		 return "index";
	}
	
	@GetMapping("/add") //since we need to get new page we use GET MApping
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.save(employee);
		return "redirect:/";
	}
	
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable(value="id") Long id, Model model) {
		Employee employee = service.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update";
	}
	
	@GetMapping("/delete/{id}") // using GET mapping as we are redirecting to index.html file
	public String deleteById(@PathVariable(value="id") Long id) {
		service.deleteById(id);
		return "redirect:/";
	}
	
	

}
