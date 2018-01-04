package fr.lamaud.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import fr.lamaud.pojo.User;
import fr.lamaud.service.UserService;

@Controller 
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(Map<String, Object> model) throws Exception {
		User user = this.userService.getUsers()[0];
		model.put("user", user);
		return "welcome";
	}

}
