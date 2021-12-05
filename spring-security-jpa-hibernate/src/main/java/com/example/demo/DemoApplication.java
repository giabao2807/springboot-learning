package com.example.demo;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//khi chương trình chạy
		//insert vào csdl 1 user

		User user = new User();
		user.setUsername("giabao1");
		user.setPassword(passwordEncoder.encode("giabao"));
		userRepository.save(user);
		System.out.println(user);
	}


}
