package com.UnitTest.easymock;

import com.UnitTest.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl() {

	}

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;

	}

	@Override
	public void add(User user) {

		if (user == null)

			throw new RuntimeException("用户为空");
		else
			userDao.add(user);

	}

	@Override
	public User login(String username, String password) {
		if (username == null)
			throw new RuntimeException("用戶名不存在");
		if (password == null)
			throw new RuntimeException("密码不存在");
		User loginUser = userDao.getByUsername(username);
		if (loginUser == null)
			throw new RuntimeException("不存在用户");
		else if (!password.equals(loginUser.getPassword()))
			throw new RuntimeException("密码错误");

		else
			return loginUser;
	}

}
