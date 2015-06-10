package com.zawila;

import com.zawila.com.zawila.client.ClientManager;
import com.zawila.com.zawila.client.ElasticSearchManager;
import com.zawila.com.zawila.client.StoreManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {ClientManager.class, ElasticSearchManager.class})
@ComponentScan
public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}