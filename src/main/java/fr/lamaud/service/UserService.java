package fr.lamaud.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.lamaud.pojo.User;

@Service(value="userService")
public class UserService {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public User[] getUsers() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8090/user", User[].class);
	}
}
