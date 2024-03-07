package com.employee.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.model.Employee;
import com.employee.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> showAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee e) {
		
		employeeRepository.save(e);
		
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Employee e = null;
		if(Objects.nonNull(id)) {
			Optional<Employee> emp=employeeRepository.findById(id);
			if(emp.isPresent()) {
				e=emp.get();
			}else {
				throw new RuntimeException("employee not found");
			}
		}
		return e;
	}

	@Override
	public void deleteById(Long id) {

		if(Objects.nonNull(id)) {
			employeeRepository.deleteById(id);;
			
		}
	}

}
