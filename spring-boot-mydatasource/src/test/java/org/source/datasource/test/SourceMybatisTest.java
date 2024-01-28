package org.source.datasource.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.source.datasource.entity.User;
import org.source.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * mybatis源码测试
 *
 * @author Mr_wenpan@163.com 2022/04/05 12:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SourceMybatisTest {

	@Autowired
	private UserService userService;

	@Test
	public void test() throws SQLException {
		List<User> userList = userService.getUserList();
		System.out.println("userList = " + userList);
	}
}
