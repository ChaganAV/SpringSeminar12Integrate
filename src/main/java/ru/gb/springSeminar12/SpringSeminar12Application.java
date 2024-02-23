package ru.gb.springSeminar12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Map;

@SpringBootApplication
public class SpringSeminar12Application {

	public static void main(String[] args) {

		SpringApplication.run(SpringSeminar12Application.class, args);
//		String dir = System.getProperty("user.dir");
//		File file = new File(dir,"fileProducts.txt");
//		System.out.println(file);
	}

}
