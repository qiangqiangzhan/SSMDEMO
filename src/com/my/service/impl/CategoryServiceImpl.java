package com.my.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my.mapper.CategoryMapper;
import com.my.pojo.Category;
import com.my.service.CategoryService;
import com.my.util.Page;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper categoryMapper;
	
	public List<Category> list() {
		return categoryMapper.list();
	}

	@Override
	public int total() {
		return categoryMapper.total();
	}

	@Override
	public List<Category> list(Page page) {
		return categoryMapper.list(page);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public void addTwo() {
		Category c1 = new Category();
		c1.setName("短的名字");
		
		categoryMapper.add(c1);
		
		Category c2 = new Category();
		c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,"
				+ "  名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,"
				+ "名字长对应字段放不下,");
		
		categoryMapper.add(c2);
		
	}

	@Override
	public void deleteAll() {
		List<Category> cs = list();
        for (Category c : cs) {  
            categoryMapper.delete(c.getId());
        }
		
	}

}
