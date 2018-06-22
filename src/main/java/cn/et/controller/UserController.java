/**
 * 
 */
package cn.et.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.et.mapper.UserMapper;

/**
 * @author Qixiaohao
 * @version 1.0
 * 
 */
@RestController
public class UserController {
	@Autowired
	UserMapper userMapper;

	@PostMapping("/addUser")
	public String addUser(@RequestBody Map map) {
		userMapper.addUser(map.get("userName").toString(), map.get("password").toString());
		if (map.get("userName") == null || map.get("password") == null) {
			return "0";
		}
		return "1";
	}

	@PutMapping("/updateUser/{userId}")
	public String updateUser(@PathVariable String userId, @RequestBody Map map) {
		try {
			userMapper.updateUser(userId, map);
			return "1";
		} catch (Exception e) {

			e.printStackTrace();
			return "0";
		}
	}

	@GetMapping("/loginUser")
	public String loginUser(String userName, String password) {
		Map map = userMapper.loginUser(userName, password);
		if (map == null) {
			return "0";
		} else {
			return "1";
		}
	}

	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable String userId) {
		userMapper.deleteUser(userId);
		return "1";

	}

}
