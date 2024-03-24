package com.cjy.usarttest.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Home {
    public String temp;
    public String light;
    public String fire;
    public String day;
    public String night;
    public String time;

    public void init(String message){
        setTemp(message.substring(0,4));
        setLight(message.substring(4,6));
        setFire(message.substring(6,7));
        setDay(message.substring(7,8));
        setNight(message.substring(8,9));
        setTime(message.substring(9,28));
    }
}
