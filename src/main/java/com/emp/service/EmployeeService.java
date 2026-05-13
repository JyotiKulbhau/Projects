package com.emp.service;

import java.util.List;

import com.emp.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	Employee updateEmployee(Long id, Employee employee);

	void deleteEmployee(Long id);
}
