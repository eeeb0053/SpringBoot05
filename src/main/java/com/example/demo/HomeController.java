package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping ("/")
    public String index(){
        System.out.println("==== 서버가 시작됨 ====");
        return "index";
    }
}
