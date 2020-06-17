package com.soft1851.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author 12559
 */
@Configuration
public class WebSocketConfig {

    /**
     * 注入 ServerEndpointExporter bean对象, 自动注册使用了 @ServerEndpoint 注解的bean
     *
     * @return ServerEndpointExporter
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
