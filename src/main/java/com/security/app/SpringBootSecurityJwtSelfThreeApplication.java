package com.security.app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.security.app.model.Role;
import com.security.app.model.User;
import com.security.app.repository.RoleRepository;
import com.security.app.repository.UserRepository;

@SpringBootApplication
public class SpringBootSecurityJwtSelfThreeApplication {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtSelfThreeApplication.class, args);
	}

	@PostConstruct
	public void dummy() {
		Role role1 = Role.builder().roleName("ADMIN").roleDescription("This role is for super user").build();
		Role role2 = Role.builder().roleName("NORMAL").roleDescription("This role is for normal user").build();

		roleRepository.save(role1);
		roleRepository.save(role2);
		System.out.println("----- 2 roles saved -----");

		User user1 = User.builder().id(101L).username("sayan").password("root").email("sayan@gmail.com").role(role1)
				.build();
		User user2 = User.builder().id(102L).username("ankan").password("1234").email("ankan@gmail.com").role(role2)
				.build();
		User user3 = User.builder().id(103L).username("arpan").password("5678").email("arpan@gmail.com").role(role2)
				.build();

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		System.out.println("----- 3 users saved -----");
	}

}
