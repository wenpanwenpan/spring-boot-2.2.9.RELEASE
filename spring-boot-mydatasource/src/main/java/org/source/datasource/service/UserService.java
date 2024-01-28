package org.source.datasource.service;

import org.source.datasource.entity.User;
import org.source.datasource.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户service
 *
 * @author Mr_wenpan@163.com 2022/04/05 12:00
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 获取所有用户信息
	 */
	public List<User> getUserList(){

		return userMapper.getUserList();
	}
}
