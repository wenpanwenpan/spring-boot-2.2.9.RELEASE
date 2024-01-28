package org.source.cache.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.source.cache.entity.Employee;
import org.source.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 员工service
 *
 * @author Mr_wenpan@163.com 2022/04/06 11:30
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Cacheable(cacheNames = {"emp"},key = "#id",condition = "#id > 0", unless = "#result == null")
	public Employee getEmpById(Integer id){

		return employeeMapper.getEmpById(id);
	}

	public Integer insertEmp(Employee employee){

		return employeeMapper.insertEmp(employee);
	}

	@CachePut(cacheNames = {"emp"}, key = "#result.id")
	public Employee updateEmp(Employee employee){
		employeeMapper.updateEmp(employee);
		return employee;
	}

	@CacheEvict(cacheNames = {"emp"},key = "#id",beforeInvocation = true)
	public Integer deleteEmpById(Integer id){

		return employeeMapper.deleteEmpById(id);
	}

}
