package com.UnitTest.dbunit;

import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

import com.UnitTest.User;
import static org.junit.Assert.*;
public class TestUser extends BaseTest {

	
	@Test
	public void testGetUser() throws Exception{
		  // 首先获取到default-data.xml文件中的内容  
		IDataSet ds=getDataSet("default-data");
		  // 调用backupAll方法保存数据库表 
		backupAll();
		// 将default-data.xml中的内容替换成数据库的内容  
		DatabaseOperation.CLEAN_INSERT.execute(connection, ds);
		 // 进行单元测试逻辑的判断  
		User user=new User();
		user.setId(1);
		user.setUsername("123");
		user.setPassword("456");
		
		assertNotNull(user);
		assertEquals(user.getId(),new Integer(1));
		assertEquals(user.getPassword(),"456");
		assertEquals(user.getUsername(),"123");
		 // 最后进行数据库的恢复  
        // 当然我们也可以将backupAll和recover放在@Before和@After当中 
		recover();
		
		
	}
}
