package com.sscorp.sscorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication
/*@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})*/
public class SscorpApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(SscorpApplication.class, args);
			System.out.println("app started successfully!");
		} catch (Throwable e){
			System.out.println(e);
		}

	}

}
