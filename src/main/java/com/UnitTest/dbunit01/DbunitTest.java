package com.UnitTest.dbunit01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DbunitTest {

	private IDatabaseTester db;
	@Before
	public void setUp() throws Exception {
		String filePath = Thread
				.currentThread()
				.getContextClassLoader()
				.getResource(
						"mybatis_user.xml")
				.getPath();
		db = TestDbUtil.getLocalDatabaseTester0();
		IDataSet dataSet = new FlatXmlDataSet(new FileInputStream(new File(
				filePath)));
		//db.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		db.setDataSet(dataSet);
		db.onSetup();
		
	}
	@Test
	public void testInsert() throws DataSetException, SQLException, Exception
	{
		
		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.getConnection();
		
		String sql = "insert into users (id,NAME, age) values (?, ?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add("1");
		params.add("123");
		params.add("12");
		
		try {
			boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ITable testTable;
		testTable = db.getConnection().createQueryTable("any_table",
				"select * from users where id='1'");
		assertEquals(1, testTable.getRowCount());
		//assertNotNull(testTable.getValue(0, "pin"));
		
	}

	@After
	public void tearDown() throws Exception {
		db.setTearDownOperation(DatabaseOperation.DELETE_ALL);
	    db.onTearDown();
	}

	

}
