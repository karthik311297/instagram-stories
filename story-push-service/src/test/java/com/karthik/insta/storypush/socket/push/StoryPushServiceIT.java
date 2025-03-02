package com.karthik.insta.storypush.socket.push;

import com.karthik.insta.datamodel.story.model.StoryMetadata;
import com.karthik.insta.datamodel.story.repository.StoryMetaDataRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.io.IOException;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StoryPushServiceIT {
    private static final PostgreSQLContainer<?> dbContainer = new PostgreSQLContainer<>(
            "postgres:15-alpine");

    @LocalServerPort
    private Integer port;

    @BeforeAll
    static void setup() {
        dbContainer.withDatabaseName("test").withUsername("sa").withPassword("sa");
        dbContainer.withInitScript("test-schema-data.sql");
        dbContainer.start();
        System.out.println("DB started at : " + dbContainer.getJdbcUrl());
    }

    @AfterAll
    static void tearDown() {
        dbContainer.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", dbContainer::getJdbcUrl);
        registry.add("spring.datasource.username", dbContainer::getUsername);
        registry.add("spring.datasource.password", dbContainer::getPassword);
    }

    @Autowired
    StoryMetaDataRepository storyMetaDataRepository;

    @Autowired
    StoryPushService storyPushService;

    @Test
    @Disabled // Note: this test should be enabled only when we run locally for dev testing
    public void shouldPushStoryToFollowers() throws IOException {
        Optional<StoryMetadata> storyMetadata = storyMetaDataRepository.findById(1L);

        storyPushService.push(storyMetadata.get());

        System.out.println();
    }
}