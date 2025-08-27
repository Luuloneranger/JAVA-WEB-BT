package vn.iotstar.dao;

import vn.iotstar.model.UserModel;

public interface UserDao {
	UserModel get(String username);
}
