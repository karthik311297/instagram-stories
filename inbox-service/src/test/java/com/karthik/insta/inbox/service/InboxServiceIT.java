package com.karthik.insta.inbox.service;

import com.karthik.insta.datamodel.inbox.repository.InboxRepository;
import com.karthik.insta.datamodel.story.model.StoryMetadata;
import com.karthik.insta.datamodel.story.repository.StoryMetaDataRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

@Testcontainers
@SpringBootTest
public class InboxServiceIT {
    private static final PostgreSQLContainer<?> dbContainer = new PostgreSQLContainer<>(
            "postgres:15-alpine");

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
    InboxService inboxService;

    @Autowired
    InboxRepository inboxRepository;

    @Test
    public void shouldAddStoryToFollowersInbox() {
        Optional<StoryMetadata> storyMetadata = storyMetaDataRepository.findById(1L);

        inboxService.addStoryToFollowersInbox(storyMetadata.get());

        List<StoryMetadata> storiesInProfile1Inbox = inboxRepository.findInboxStoriesByProfileId(1L);
        List<StoryMetadata> storiesInProfile2Inbox = inboxRepository.findInboxStoriesByProfileId(2L);
        List<StoryMetadata> storiesInProfile3Inbox = inboxRepository.findInboxStoriesByProfileId(3L);
        Assertions.assertEquals(storiesInProfile1Inbox.size(), 0);
        Assertions.assertEquals(storiesInProfile2Inbox.size(), 1);
        Assertions.assertEquals(storiesInProfile3Inbox.size(), 1);
    }
}