package com.cjy.usarttest.service;

import com.cjy.usarttest.mapper.HomeMapper;
import com.cjy.usarttest.pojo.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    HomeMapper homeMapper;

    public List<Home> FindHome(String begin,String end){
        return homeMapper.FindHome(begin,end);
    }
    public List<Home> FindFire(String begin,String end){
        return homeMapper.FindFire(begin,end);
    }
    public List<Home> FindNight(String begin,String end){
        return homeMapper.FindNight(begin,end);
    }

    public int AddHome(Home home){
        return homeMapper.AddHome(home);
    }

    public int CloseHome(){
        return homeMapper.CloseHome();
    }

    public Home upHome(String ms){
        Home home=new Home();
        home.init(ms);
        return home;
    }
}
