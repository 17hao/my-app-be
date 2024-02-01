package xyz.shiqihao.app.service;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;

@Component
public class WebSocketService {
    public WebSocketMessage<String> buildMessage(String message) {
        return new TextMessage(message);
    }
}
