package org.source.datasource.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 测试数据源
 *
 * @author Mr_wenpan@163.com 2022/04/04 19:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SourceDataSourceTest {

	@Autowired
	private DataSource dataSource;

	@Test
	public void test() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println("connection = "  + connection);
	}
}
