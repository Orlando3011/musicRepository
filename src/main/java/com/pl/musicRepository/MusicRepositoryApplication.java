package com.pl.musicRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MusicRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicRepositoryApplication.class, args);
	}

}
