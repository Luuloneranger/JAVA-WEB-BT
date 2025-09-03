package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.UserModel;

public interface UserService {
	
	UserModel login(String username, String password);
	UserModel get(int id);
	UserModel get(String username);
	void insert(UserModel user);
	boolean register(int id,String username,String password,String fullname);
	boolean chekcExistUsername(String username);
	void edit(UserModel user);
	void delete( int id);
	List<UserModel> getall();
}
