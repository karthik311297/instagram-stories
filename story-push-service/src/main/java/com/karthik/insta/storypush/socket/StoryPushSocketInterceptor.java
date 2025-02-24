package com.karthik.insta.storypush.socket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

import static com.karthik.insta.storypush.socket.StoryPushWebSocketHandler.PROFILE_ID_SESSION_ATTRIBUTE;

public class StoryPushSocketInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
        String profileIdQueryParam = request
                .getURI().getQuery();
        if (profileIdQueryParam != null && profileIdQueryParam
                .startsWith(PROFILE_ID_SESSION_ATTRIBUTE + "="))
        {
            attributes.put(PROFILE_ID_SESSION_ATTRIBUTE, Long.parseLong(profileIdQueryParam.split("=")[1]));
            return true;
        }
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
