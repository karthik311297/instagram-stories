package com.karthik.insta.storypush.socket.push;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.karthik.insta.datamodel.follow.repository.FollowGraphRepository;
import com.karthik.insta.datamodel.profile.model.Profile;
import com.karthik.insta.datamodel.story.model.StoryMetadata;
import com.karthik.insta.storypush.socket.ConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;

@Service
public class StoryPushService {

    @Autowired
    public FollowGraphRepository followGraphRepository;

    public void push(StoryMetadata storyMetadata) throws IOException {
        List<Profile> followersOfProfile = followGraphRepository
                .findFollowersOfProfile(storyMetadata.getProfile());
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        for (Profile follower : followersOfProfile) {
            WebSocketSession session = connectionManager.getClientSession(follower.getId());
            if (session == null) continue;
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            session.sendMessage(
                    new TextMessage(objectMapper.writeValueAsString(storyMetadata)));
        }
    }
}
