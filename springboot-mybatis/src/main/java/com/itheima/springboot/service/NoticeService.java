package com.itheima.springboot.service;

import java.util.List;
import java.util.Map;

import com.itheima.springboot.pojo.Notice;

public interface NoticeService {

	//查询所有公告
	public List<Notice> findAll();

	public Long count();
	
	//分页查询
	public Map<String, Object> findByPage(Integer page, Integer rows);
	
}
