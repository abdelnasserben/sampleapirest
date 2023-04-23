package com.dabel.sampleapirest.service;

import java.lang.reflect.Field;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.dabel.sampleapirest.model.Employee;
import com.dabel.sampleapirest.repository.EmployeeRepository;

/**
 * Class to apply the business and management 
 * rules of the application
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updatePartially(int id, java.util.Map<String, Object> fields) {
		
		Employee employee = employeeRepository.findById(id).get();
		
		fields.forEach((key, value) -> {
			
			Field field = ReflectionUtils.findRequiredField(Employee.class, key);
			ReflectionUtils.setField(field, employee, value);
		});
		
		return employeeRepository.save(employee);
	}
	
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
