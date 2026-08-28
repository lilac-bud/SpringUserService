package io.github.lilacbud.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringUserService {
    public static void main(String[] args) {
        SpringApplication.run(SpringUserService.class, args);
    }
}
