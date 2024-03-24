package com.cjy.usarttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class UsartTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsartTestApplication.class, args);

    }

}
