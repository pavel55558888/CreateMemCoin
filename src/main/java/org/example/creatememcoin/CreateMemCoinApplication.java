package org.example.creatememcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CreateMemCoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreateMemCoinApplication.class, args);
    }

}
