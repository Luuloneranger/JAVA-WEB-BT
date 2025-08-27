package vn.iotstar.service;

import vn.iotstar.model.UserModel;

public interface UserService {
	
	UserModel login(String username, String password);
	UserModel get(String username);
}
