package com.dabel.sampleapirest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dabel.sampleapirest.exception.EmployeeNotFoundException;
import com.dabel.sampleapirest.model.Employee;
import com.dabel.sampleapirest.service.EmployeeService;

/**
 * Rest controller class to map HTTP verbs
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public ResponseEntity<Iterable<Employee>> getAllEmployees() {
		
		Iterable<Employee> employees = employeeService.findAll();
		
		if(!employees.iterator().hasNext())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		
		Employee checkEmployee = employeeService.findById(id).orElseThrow(
					() -> new EmployeeNotFoundException("Employé introuvable !")
				);
				
		return ResponseEntity.ok(checkEmployee);
	}
	
	@PostMapping("/")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		
		Employee savedEmployee = employeeService.save(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		
		Employee checkEmployee = employeeService.findById(id).orElseThrow(
					() -> new EmployeeNotFoundException("Identifiant inexistant !")
				);
		
		//update employee id to be replaced content
		employee.setId(checkEmployee.getId());
		employeeService.save(employee);
		
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> updateEmployeePartially(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		
		employeeService.findById(id).orElseThrow(
					() -> new EmployeeNotFoundException("Identifiant inexistant !")
				);
		
		employeeService.updatePartially(id, fields);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
		
		employeeService.findById(id).orElseThrow(
					() -> new EmployeeNotFoundException("Identifiant inexistant !")
				);
		
		employeeService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
