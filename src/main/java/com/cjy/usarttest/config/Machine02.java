package com.cjy.usarttest.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author chengjy
 * @date 2023-10-06
 */

@Component
public class Machine02 implements Runnable{
    public String message="124.526.30300010000";
    public OutputStream out;
    @PostConstruct
    public void init() {
        new Thread(this).start();
    }
    @Override
    public void run(){
        try {
            while (true) {
                ServerSocket serverSocket = new ServerSocket(8088);
                System.out.println("等待二号机连接...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("二号机已连接");
                clientSocket.setSoTimeout(6000);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                InputStream input = clientSocket.getInputStream();
                out = clientSocket.getOutputStream();
                while (true) {
                    try {
                        message = in.readLine();
                        System.out.println(message);
                    } catch (SocketTimeoutException e) {
                        System.out.println("二号机连接断开");
                        serverSocket.close();
                        clientSocket.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
