package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.UserModel;

public interface UserDao {
	UserModel get(int id);
	UserModel get (String username);
	void insert(UserModel user);
	boolean checkExistUsername(String username);
	UserModel findbyUandF(String username, String fullname);
	void edit(UserModel user);
	void delete( int id);
	List<UserModel> getall();
	List<UserModel> search(String keyword);
}
