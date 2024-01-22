package com.desafio.challengeSicredi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ChallengeSicrediApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeSicrediApplication.class, args);
	}

}
