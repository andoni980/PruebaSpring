package com.pruebaSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PruebaSpringApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PruebaSpringApplication.class, args);
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		
		
//		String pass = passwordEncoder.encode("andoni");
//		
//		System.out.println(pass);
//		
//		System.out.println(passwordEncoder.matches("andoni", pass));
	}


}
