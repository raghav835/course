package com.cms.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private String queueName;
    private String host;
    private int port;
    private String userName;
    private String password;
    private String virtualHost;

    public RabbitMQConfig() {
        // Initialize the configuration variables
        queueName = "myQueue";
        host = "localhost";
        port = 5672;
        userName = "guest";
        password = "guest";
        virtualHost = "/";
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }
}

	
	
	
	
	
}
