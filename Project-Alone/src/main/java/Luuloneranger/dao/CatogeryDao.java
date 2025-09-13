package Luuloneranger.dao;

import java.util.List;

import Luuloneranger.entity.Catogery;

public interface CatogeryDao {
	void insert(Catogery c);
	void update (Catogery c);
	void delete (int cate_id);
	Catogery findbyId(int cate_id);
	List<Catogery> findAll();
}
