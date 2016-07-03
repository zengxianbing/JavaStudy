package com.UnitTest.easymock;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;

import com.UnitTest.User;

public class TestUserService {

	private User admin;
	private UserDao userDao;
	private UserService userService;

	@Before
	public void setUp() {
		// 初始化一个用户
		admin = new User(1, "Ray", "123");

		// 创建UserDao的Mock对象
		userDao = EasyMock.createMock(UserDao.class);
		userService = new UserServiceImpl(userDao);
	}

	@Test
	public void testLogin() {

		/*
		 * 以下开始进入record阶段
		 */

		// 此时说明当在Dao中调用get方式时并且参数为Ray的时候应该返回1个用户对象给我
		EasyMock.expect(userDao.getByUsername("Ray")).andReturn(admin);

		/*
		 * 以下进入replay阶段
		 */

		// 将使用userDao创建的Mock对象传入
		EasyMock.replay(userDao);
		// 直接调用 接口的方法
		User loginUser = userService.login("Ray", "123");
		// 使用断言判断是否为空
		Assert.assertNotNull(loginUser);

		/*
		 * 进入verify阶段
		 */
		EasyMock.verify(userDao);

	}

	@Test
	public void testAdd() {

		IMocksControl mc = EasyMock.createStrictControl();

		userDao = mc.createMock(UserDao.class);

		userDao.add(admin);

		EasyMock.expectLastCall();

		EasyMock.expect(userDao.getByUsername("Ray")).andReturn(admin);
		EasyMock.replay(userDao);

		userDao.add(admin);

		User addUser = userDao.getByUsername("Ray");
		Assert.assertNotNull(addUser);

		EasyMock.verify(userDao);

		mc.reset();

	}

}
