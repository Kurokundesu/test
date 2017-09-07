package com.itheima.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.springboot.pojo.Notice;
import com.itheima.springboot.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("findAll")
	@ResponseBody
	public List<Notice> findAll(){
		return noticeService.findAll();
	}
	
	@GetMapping("show")
	public String show(){
		return "/html/notice.html";
	}
	
	@PostMapping("/findByPage")
	@ResponseBody
	public Map<String, Object> findByPage(Integer page, Integer rows){
		return noticeService.findByPage((page - 1) * rows, rows);
	}
}
