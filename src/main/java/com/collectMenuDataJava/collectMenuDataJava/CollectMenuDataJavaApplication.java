package com.collectMenuDataJava.collectMenuDataJava;

import com.collectMenuDataJava.collectMenuDataJava.Menu.MenuList;
import com.collectMenuDataJava.collectMenuDataJava.tools.Hello;
import com.example.menudetection.tools.ExtractImage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectMenuDataJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectMenuDataJavaApplication.class, args);
		Hello hello = new Hello();
		hello.hello();
	}

}
