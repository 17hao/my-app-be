package xyz.shiqihao.app.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import xyz.shiqihao.app.service.WebSocketService;

@AllArgsConstructor
public class WebSocketController extends TextWebSocketHandler {
    private final WebSocketService service;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println("receive message: " + message);
        try {
            session.sendMessage(service.buildMessage(LocalDateTime.now().toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
