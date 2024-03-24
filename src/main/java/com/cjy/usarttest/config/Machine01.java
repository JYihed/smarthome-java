package com.cjy.usarttest.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author chengjy
 * @date 2023-10-06
 */

@Component
public class Machine01 implements Runnable {

public String message="124.526.30300010000";
public OutputStream out;
    @PostConstruct
    public void init() {
        //启动线程实例
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String time ;
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                Date date=new Date();
                message=df.format(date);
                time="time:"+message;
                message="00.0000102023-10-15 10:53:08";
                ServerSocket serverSocket = new ServerSocket(8080);
                System.out.println("等待一号机连接...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("一号机已连接");
                clientSocket.setSoTimeout(6000);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                //InputStream input = clientSocket.getInputStream();
                out = clientSocket.getOutputStream();
                out.write(time.getBytes());
                while (true) {
                    try {
                        message = in.readLine();
                        System.out.println(message);
                    } catch (SocketTimeoutException e) {
                        System.out.println("一号机连接断开");
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