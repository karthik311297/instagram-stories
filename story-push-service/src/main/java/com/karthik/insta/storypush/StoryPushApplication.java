package com.karthik.insta.storypush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.karthik.insta.datamodel")
@EnableJpaRepositories("com.karthik.insta.datamodel")
@ComponentScan("com.karthik.insta.storypush")
public class StoryPushApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoryPushApplication.class, args);
    }
}
