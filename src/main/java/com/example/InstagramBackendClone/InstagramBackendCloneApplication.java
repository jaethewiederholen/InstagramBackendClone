package com.example.InstagramBackendClone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
public class InstagramBackendCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstagramBackendCloneApplication.class, args);
	}

}
