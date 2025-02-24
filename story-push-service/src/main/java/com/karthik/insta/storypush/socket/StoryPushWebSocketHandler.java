package com.karthik.insta.storypush.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class StoryPushWebSocketHandler extends TextWebSocketHandler {

    public static final String PROFILE_ID_SESSION_ATTRIBUTE = "profileId";

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        ConnectionManager.getInstance().addClientSession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception
    {
        super.afterConnectionClosed(session, status);
        Long profileId = (Long) session.getAttributes()
                .get(StoryPushWebSocketHandler.PROFILE_ID_SESSION_ATTRIBUTE);
        ConnectionManager.getInstance().removeClientSession(profileId);
    }
}
