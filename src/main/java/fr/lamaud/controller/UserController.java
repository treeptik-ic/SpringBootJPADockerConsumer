package fr.lamaud.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
	public String getUsers(Model model) throws Exception {
		model.addAttribute("user", new User());
		model.addAttribute("users", this.userService.getUsers());
		return "welcome";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postUser(@ModelAttribute User user, Model model) throws Exception {
		model.addAttribute("user", new User());
		
		this.userService.postUserToRest(user);
		
		model.addAttribute("users", this.userService.getUsers());
		return "welcome";
	}
}
