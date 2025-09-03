package vn.iotstar.service;

import java.util.List;

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


	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}


	@Override
	public boolean register(int id, String username, String password, String fullname) {
		if(userDao.checkExistUsername(username))
			return false;
		userDao.insert(new UserModel(id,username,fullname,password));
		return true;
	}


	@Override
	public boolean chekcExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}


	@Override
	public void edit(UserModel user) {
		UserModel oldUser = userDao.get(user.getUserName());
		oldUser.setFullName(user.getFullName());
		oldUser.setPassWord(user.getPassWord());
		userDao.edit(oldUser);
		
	}


	@Override
	public void delete(String username) {
		userDao.delete( username);
	}


	@Override
	public List<UserModel> getall() {
		return userDao.getall();
	}
}
