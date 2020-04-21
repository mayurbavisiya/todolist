package com.geeks.todo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableJpaRepositories("com.geeks.todo.repository")
@EnableTransactionManagement
@EntityScan("com.geeks.todo.beans")
public class TodoApplication{

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}


}