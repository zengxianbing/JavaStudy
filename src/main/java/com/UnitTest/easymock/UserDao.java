package com.UnitTest.easymock;

import com.UnitTest.User;

public interface UserDao {

	User getByUsername(String username);
	
	void add(User user);
}
