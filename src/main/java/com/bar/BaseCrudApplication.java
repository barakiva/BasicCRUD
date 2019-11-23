package com.bar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseCrudApplication {
	//*Current issues to be resolved*
	//1. Once deleted, entities do not fill empty spots
	//2. Server crashes when interacting with entities that do not exist
	//3. Scope? Do entities have it?
	//4. How do i make sure I only update what is new?
	public static void main(String[] args) {
		SpringApplication.run(BaseCrudApplication.class, args);
	}

}
