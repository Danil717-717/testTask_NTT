package ru.aoNTT.testTask_NTT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "ru.aoNTT.testTask_NTT.models.entity")
public class TestTaskNttApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTaskNttApplication.class, args);
	}

}
