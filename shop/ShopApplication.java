package com.ubb.shop;

import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(ShopApplication.class, args);
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(System.getenv("RABBITMQ_URI"));
		factory.setPort(5672);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare("product_queue", false, false, false, null);
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(
					String consumerTag,
					Envelope envelope,
					AMQP.BasicProperties properties,
					byte[] body) throws IOException {

				String message = new String(body, "UTF-8");
				System.out.println("A message was consumed from the queue: "+message);
			}
		};
		channel.basicConsume("product_queue", true, consumer);
	}

}
