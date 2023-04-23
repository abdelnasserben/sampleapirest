package com.dabel.sampleapirest.repository;

import org.springframework.data.repository.CrudRepository;

import com.dabel.sampleapirest.model.Employee;

/**
 * Class to make the link between the 
 * application and the database 
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
