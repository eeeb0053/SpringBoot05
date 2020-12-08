package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.domains.ArticleDTO;
import com.example.demo.services.ArticleService;
import com.example.demo.utils.Printer;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired ArticleService articleService;
    @Autowired Printer printer;
    @Autowired Proxy px;
    @PostMapping("/articles")
    public Map<?, ?>  write(@RequestBody ArticleDTO article){
        var map = px.hashmap();
        int result = articleService.write(article);
        if(result == 1){
            map.put("message", "SUCCESS");
        }else{
            map.put("message", "FAILURE");
        }
        return map;
    }
    @GetMapping("/articles")
    public Map<?, ?> list(){
        var map = px.hashmap();
        List<ArticleDTO> list = articleService.list();
        map.put("list", list);
        return map;
    }
}
