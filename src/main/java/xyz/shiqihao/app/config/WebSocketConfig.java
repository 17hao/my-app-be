package xyz.shiqihao.app.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import xyz.shiqihao.app.controller.WebSocketController;
import xyz.shiqihao.app.service.WebSocketService;

@EnableWebSocket
@Configuration
@AllArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private WebSocketService service;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WebSocketController(service), "/datetime");
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new WebSocketController(service);
    }

}
