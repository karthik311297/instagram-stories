package com.karthik.insta.storypush.socket.push;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthik.insta.storypush.socket.ConnectionManager;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;

public class StoryPusher {

    public static void push(com.karthik.insta.storypush.socket.StoryMetadata storyMetadata, List<Long> followers) throws IOException
    {
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        for(Long follower : followers)
        {
            WebSocketSession session = connectionManager.getClientSession(follower);
            session.sendMessage(
                    new TextMessage(new ObjectMapper().writeValueAsString(storyMetadata)));
        }
    }
}
