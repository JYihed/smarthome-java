package com.cjy.usarttest.mapper;

import com.cjy.usarttest.pojo.Home;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {
    List<Home> FindHome(String begin, String end);

    List<Home> FindFire(String begin, String end);

    List<Home> FindNight(String begin, String end);

    int AddHome(Home home);

    int CloseHome();
}
