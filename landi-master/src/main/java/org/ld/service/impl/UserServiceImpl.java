package org.ld.service.impl;

import org.apache.log4j.Logger;
import org.ld.dao.UserDao;
import org.ld.model.User;
import org.ld.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 用户service实现类  */
@Service("userService")
public class UserServiceImpl implements IUserService {


	@Autowired
	private UserDao userInfoMapper;


	@Override
	public User getUserByUserName(String name) {
		return userInfoMapper.selectByUserName(name);
	}

	
}
