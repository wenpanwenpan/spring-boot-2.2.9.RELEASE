package org.source.cache.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.source.cache.entity.Employee;

/**
 * 员工mapper
 *
 * @author Mr_wenpan@163.com 2022/04/06 11:25
 */
public interface EmployeeMapper {

	@Select("select * from employee where id = #{id}")
	Employee getEmpById(Integer id);

	@Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
	Integer insertEmp(Employee employee);

	@Update("update employee set last_name = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId}")
	Integer updateEmp(Employee employee);

	@Delete("delete from employee where id = #{id}")
	Integer deleteEmpById(Integer id);
}
