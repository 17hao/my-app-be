package xyz.shiqihao.app.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;

@Component
public class WebSocketService {
    public WebSocketMessage<String> buildResponse(String req) {
        System.out.println("receive message: " + req);
        Map<String, String> map = new HashMap<>();
        map.put("datetime", LocalDateTime.now().toString());
        return new TextMessage(new Gson().toJson(map));
    }
}
