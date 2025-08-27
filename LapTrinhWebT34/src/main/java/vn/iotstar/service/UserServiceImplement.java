package vn.iotstar.service;

import vn.iotstar.dao.UserDao;
import vn.iotstar.model.UserModel;
import vn.iotstar.dao.UserDaoImpl;

public class UserServiceImplement implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}


	@Override
	public UserModel get(String username) {
		return userDao.get(username);
	}
}
