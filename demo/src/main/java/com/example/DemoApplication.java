package com.example;

import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private static void printClasspath() {
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		URL[] urls = ((URLClassLoader)cl).getURLs();

		for(URL url: urls){
			System.out.println(url.getFile());
		}
	}
}
