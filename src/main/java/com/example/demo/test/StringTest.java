package com.example.demo.test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class StringTest {
    public static void main(String[] args) {
        String one = "1";
        String two = "2";
        int o = Integer.parseInt(one);
        int t = Integer.parseInt(two);
        String sum = String.valueOf(o + t);
        System.out.println("1 + 2 = "+sum);
        int r = (int)(Math.random() * 45) + 1;
        System.out.println("랜덤수: "+r);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
