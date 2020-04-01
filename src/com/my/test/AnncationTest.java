package com.my.test;

import java.lang.reflect.Constructor;
import java.util.ResourceBundle;

import com.my.pojo.Category;
import com.my.util.Page;

public class AnncationTest {
	public static void Resource() throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("Page");
		String obj = rb.getString("category");
		Class c = Class.forName(obj);
		Constructor cr = c.getConstructor();
		Category cg =  (Category)cr.newInstance();
		System.out.println(cg);
	}
	public static void main(String[] args) {
		try {
			// 绫诲璞�?
			Class s = Class.forName("com.how2java.pojo.Page");
			Class s1 = new Page().getClass();
			Class s2 = Page.class;
			
			System.out.println(s == s1);
			System.out.println(s1 == s2);
			System.out.println(s == s2);
			
			//閫氳繃鍙嶅皠鏉ュ垱寤哄璞�
			//鑾峰彇绫荤殑鏋勯�犲嚱鏁�?
			Constructor c = s.getConstructor();
			//浣跨敤绫荤殑鏋勯�犲嚱鏁版潵鍒涘缓�?�炰綋绫�?
			Page p = (Page)c.newInstance();
			System.out.println(p);
			
			//浠庨厤缃枃浠朵腑鍙栧嚭闇�瑕佽繘琛屽疄渚嬪寲鐨勫璞�
			Resource();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
