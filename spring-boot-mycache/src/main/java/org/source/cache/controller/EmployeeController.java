package org.source.cache.controller;

import org.source.cache.entity.Employee;
import org.source.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工controller
 *
 * @author Mr_wenpan@163.com 2022/04/06 11:33
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable("id") Integer id){

		return employeeService.getEmpById(id);
	}

	@GetMapping("/emp/update/{id}")
	public Employee updateEmployee(@PathVariable("id") Integer id){
		// 先查询
		Employee employee = employeeService.getEmpById(id);
		employee.setLastName("wenpanfeng");
		employeeService.updateEmp(employee);
		return employee;
	}

	@GetMapping("/emp/delete/{id}")
	public void deleteEmpById(@PathVariable("id") Integer id){
		employeeService.deleteEmpById(id);
	}
}
