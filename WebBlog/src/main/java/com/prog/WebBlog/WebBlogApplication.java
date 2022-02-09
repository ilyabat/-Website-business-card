package com.prog.WebBlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.prog.WebBlog.*"})

public class WebBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBlogApplication.class, args);
	}

}
