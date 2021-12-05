package com.example.demo;

import com.example.demo.controller.AccountController;
import com.example.demo.entity.Account;
import com.example.demo.entity.Source;
import com.example.demo.service.AccountService;
import com.example.demo.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	AccountService accountService;

	@Autowired
	SourceService sourceService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Account> accounts = accountService.findAll();

		List<Source> sources = sourceService.findAll();

		for(Account account:accounts){
			System.out.println(account);
		}

		for(Source soucre:sources){
			System.out.println(soucre);
		}
	}
}
