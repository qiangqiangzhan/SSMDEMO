package com.my.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.mapper.CategoryMapper;
import com.my.pojo.Category;
import com.my.service.CategoryService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
    private CategoryService categoryService;

//	@Test
//	public void testAdd() {
//		for (int i = 0; i < 100; i++) {
//			Category category = new Category();
//			category.setName("new Category");
//			categoryMapper.add(category);
//	    }
//	}

//	@Test
//	public void testList() {
//		System.out.println(categoryMapper);
//		List<Category> cs=categoryMapper.list();
//		for (Category c : cs) {
//			System.out.println(c.getName());
//		}
//	}
	
	@Test
    public void testAddTwo() {
        //categoryService.deleteAll();
        categoryService.addTwo();       
    }

}
