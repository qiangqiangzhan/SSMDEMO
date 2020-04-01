package com.my.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.my.pojo.Category;
import com.my.service.CategoryService;
import com.my.util.Page;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page) {
		
		ModelAndView mav = new ModelAndView();
		
		int total = categoryService.total();
		page.caculateLast(total);
		
		if (page.getStart() >= total) { 
			page.setStart(page.getLast());
		}
		if (page.getStart() < 0) {
			page.setStart(0);
		}
		
		List<Category> list = categoryService.list(page);
		mav.addObject("list", list);
		mav.setViewName("listCategory");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/submitCategory")
	public String submitCategory(@RequestBody Category category) {
		System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:"+category);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/getOneCategory")
	public String getOneCategory() {
		Category c = new Category();
		c.setName("json");
//		JSONObject json = new JSONObject();
//		json.put("category", JSONObject.toJSON(c));
//		return json.toJSONString();
		return JSONObject.toJSON(c).toString();
	}
	
	@ResponseBody
	@RequestMapping("/getManyCategory")
	public String getManyCategory() {
		List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("分类名称:"+i);
            cs.add(c);
        }
        
        return JSONObject.toJSON(cs).toString();
	}
}
