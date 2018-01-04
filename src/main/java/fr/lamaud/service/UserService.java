package fr.lamaud.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.lamaud.pojo.User;

@Service(value="userService")
public class UserService {


	public User[] getUsers() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8090/user", User[].class);
	}
	
	public void postUserToRest(User user) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		User result = restTemplate.postForObject("http://localhost:8090/user", user, User.class);
	}
}
