package Luuloneranger.dao;

import java.util.List;

import Luuloneranger.entity.UserModel;

public interface UserDao {
	void insert(UserModel c1);
	void update (UserModel c1);
	void delete(int id);
	UserModel findbyUsername(String username);
	List<UserModel>findAll();
}
