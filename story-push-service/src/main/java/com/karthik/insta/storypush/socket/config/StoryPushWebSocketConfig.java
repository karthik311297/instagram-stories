package com.karthik.insta.storypush.socket.config;

import com.karthik.insta.storypush.socket.StoryPushSocketInterceptor;
import com.karthik.insta.storypush.socket.StoryPushWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class StoryPushWebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(new StoryPushWebSocketHandler(),"/story")
                .addInterceptors(new StoryPushSocketInterceptor())
                .setAllowedOrigins("*");
    }
}
