package com.demo.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.util.Message;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年7月25日 下午7:30:16
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;

	@RequestMapping("/addUser")
	@ResponseBody
	public Object  addUser(String username,String password){
		
		User record = new User();
		record.setPassword(password);
		record.setUsername(username);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:s");
		record.setUpdateTime(format.format(new Date()));
		record.setCreateTime(new Date());
		
		userService.insert(record);
		
		return Message.getMessage();
		
	}
	
}
