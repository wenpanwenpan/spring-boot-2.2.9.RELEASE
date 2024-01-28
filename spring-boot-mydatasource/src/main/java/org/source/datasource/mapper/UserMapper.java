package org.source.datasource.mapper;

import org.apache.ibatis.annotations.Select;
import org.source.datasource.entity.User;

import java.util.List;

/**
 * 用户mapper
 *
 * @author Mr_wenpan@163.com 2022/04/05 11:52
 */
public interface UserMapper {

	/**
	 * 获取所有用户
	 */
	@Select("select * from user")
	 List<User> getUserList();
}
