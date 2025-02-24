package com.karthik.insta.storypush.socket;

import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionManager {

    private static final ConnectionManager instance = new ConnectionManager();
    private static final Map<Long, WebSocketSession> clientSessions = new ConcurrentHashMap<>();

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        return instance;
    }

    public WebSocketSession getClientSession(Long profileId) {
        return clientSessions.get(profileId);
    }

    public void addClientSession(WebSocketSession webSocketSession) throws IOException
    {
        Long profileId = (Long) webSocketSession.getAttributes()
                .get(StoryPushWebSocketHandler.PROFILE_ID_SESSION_ATTRIBUTE);
        System.out.println("Session connected : " + webSocketSession.getId() + ", profile : " + profileId);
        clientSessions.put(profileId, webSocketSession);
    }

    public void removeClientSession(Long profileId) throws IOException
    {
        WebSocketSession session = clientSessions.remove(profileId);
        System.out.println("Session disconnected : " + session.getId() + ", profile : " + profileId);
        try {
        } finally {
            session.close();
        }
    }
}
