package com.my.service;

import java.util.List;

import com.my.pojo.Category;
import com.my.util.Page;

public interface CategoryService {
	List<Category> list();
	int total();
	List<Category> list(Page page);
	
	void addTwo();
	void deleteAll();
}
