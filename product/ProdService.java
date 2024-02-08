package com.ubb.prod.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.ubb.prod.domain.Prod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class ProdService {

    private List<Prod> products=new ArrayList<>(Arrays.asList(new Prod("Product1","5",10),
            new Prod("Product2","75",12),
            new Prod("Product3","50",30),
            new Prod("Product4","10",15),
            new Prod("Product5","7.5",20)));

    public List<Prod> getProducts() {
        return products;
    }

    public List<Prod> geProductByName(String name){
        List<Prod> prodList=new ArrayList<>();
        for(Prod p:products){
            if(name.equalsIgnoreCase(p.getName())){
                try {
                    ConnectionFactory factory = new ConnectionFactory();
                    factory.setHost(System.getenv("RABBITMQ_URI"));
                    factory.setPort(5672);
                    Connection connection = factory.newConnection();
                    Channel channel = connection.createChannel();
                    channel.queueDeclare("product_queue", false, false, false, null);
                    String message = p.getName();
                    channel.basicPublish("", "product_queue", null, message.getBytes());
                    System.out.println("Producer put on the queue the message: " + message);
                    channel.close();
                    connection.close();
                }catch(Exception e){
                    System.out.println("connection failed" +e);
                }
                prodList.add(p);
            }
        }
        return prodList;
    }

    public void buyProduct(String name){
        for(Prod p: products){
            if(name.equalsIgnoreCase(p.getName())){
                p.setQuantity(p.getQuantity()-1);
                break;
            }
        }
    }
}
