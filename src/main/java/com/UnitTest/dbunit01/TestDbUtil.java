package com.UnitTest.dbunit01;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;

public class TestDbUtil {

	public static IDatabaseTester getLocalDatabaseTester0() throws Exception {
		return new JdbcDatabaseTester(
				"com.mysql.jdbc.Driver",
				"jdbc:mysql://127.0.0.1:3306/mybatis?characterEncoding=utf8&amp;autoReconnect=true&amp;failOverReadOnly=false&amp;connectTimeOut=50000&amp;socketTimeOut=50000",
				"root", "123456");
	}
}
