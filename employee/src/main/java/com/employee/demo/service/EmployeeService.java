package com.employee.demo.service;

import java.util.List;

import com.employee.demo.model.Employee;

public interface EmployeeService {

	List<Employee> showAllEmployees();
	
	void save(Employee e);
	
	Employee getEmployeeById(Long id);
	
	void deleteById(Long id);
}
