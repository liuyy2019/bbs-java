package com.yang.bbs.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
 
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/6 21:29
 * ip和端口号的配置类
 */

@Configuration
@Component
public class ServerConfig  implements ApplicationListener<WebServerInitializedEvent> {
    private int serverPort;
 
    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        address.getHostAddress();
        return "http://localhost" +":"+this.serverPort;
    }
 
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }
 
}
