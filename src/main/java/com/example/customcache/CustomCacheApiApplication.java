package com.example.customcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@SpringBootApplication
public class CustomCacheApiApplication {
    public static void main(String[] args) throws Exception {
        Environment env = SpringApplication.run(CustomCacheApiApplication.class, args).getEnvironment();
        String port = env.getProperty("server.port", "8080"); // Default to 8080 if not set
        String host = InetAddress.getLocalHost().getHostAddress();

        System.out.println("Custom Cache API is running on http://" + host + ":" + port);
    }
}
