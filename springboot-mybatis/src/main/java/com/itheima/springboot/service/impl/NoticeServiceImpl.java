package com.itheima.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.springboot.mapper.NoticeMapper;
import com.itheima.springboot.pojo.Notice;
import com.itheima.springboot.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	/**
	 * 查询所有公告
	 */
	@Override
	public List<Notice> findAll() {
		return noticeMapper.findAll();
	}

	/**
	 * 分页查询公告
	 */
	@Override
	public Map<String, Object> findByPage(Integer page, Integer rows) {
		
		Map<String, Object> data = new HashMap<>();
		
		//获取总记录数
		Long count = noticeMapper.count();
		data.put("total", count);
		
		//获取分页数据
		List<Notice> noticeList = noticeMapper.findByPage(page, rows);
		data.put("rows", noticeList);
		
		return data;
	}

	@Override
	public Long count() {
		return noticeMapper.count();
	}

}
