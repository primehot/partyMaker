package com.partyMaker.partyMaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class PartyMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyMakerApplication.class, args);
	}
}
