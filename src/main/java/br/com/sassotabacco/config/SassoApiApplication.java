package br.com.sassotabacco.config;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SassoApiApplication {
	
	@PostConstruct
    public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }

	public static void main(String[] args) {
		SpringApplication.run(SassoApiApplication.class, args);
	}

}
