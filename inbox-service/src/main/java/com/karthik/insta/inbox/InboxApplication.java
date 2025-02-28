package com.karthik.insta.inbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.karthik.insta.inbox"})
@EntityScan("com.karthik.insta.datamodel")
@EnableJpaRepositories("com.karthik.insta.datamodel")
public class InboxApplication {
    public static void main(String[] args) {
        SpringApplication.run(InboxApplication.class, args);
    }
}
