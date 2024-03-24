package com.cjy.usarttest.controller;

import com.cjy.usarttest.config.Machine02;
import com.cjy.usarttest.config.Machine01;
import com.cjy.usarttest.pojo.Home;
import com.cjy.usarttest.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class UsartController {
    public Integer count=0;
    public SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    Machine01 machine01;

    @Autowired
    Machine02 machine02;

    @Autowired
    HomeService homeService;


    @GetMapping("/test1")
    public int test1()throws Exception{
        String time ;
        String message;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date=new Date();
        message=df.format(date);
        time="time:"+message;
        machine01.out.write(time.getBytes());
        return 1;
    }

    @GetMapping("/send")
    public String send (String a)throws Exception{
        System.out.println(a);
        machine01.out.write(a.getBytes());
        return "ok";
    }

    @GetMapping("/find")
    public List<Home> find(String begin,String end,int cmd){
        switch (cmd){
            case 1:return homeService.FindHome(begin,end);
            case 2:return homeService.FindFire(begin,end);
            case 3:return homeService.FindNight(begin,end);
        }
        return homeService.FindHome(begin,end);
    }

    @GetMapping("/mhome")
    public Home mhome(){
        count++;
        if(count==300){
            homeService.CloseHome();
        }
        Home home1=new Home();
        home1=homeService.upHome(machine01.message);
        homeService.AddHome(home1);
        return home1;
    }





}
