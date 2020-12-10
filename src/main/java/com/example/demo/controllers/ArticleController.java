package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import com.example.demo.domains.ArticleDTO;
import com.example.demo.services.ArticleService;
import com.example.demo.utils.Printer;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

@RestController
public class ArticleController{
    @Autowired Printer printer;
    @Autowired ArticleService articleService;
    @Autowired Proxy px;
    
    @PostMapping("/articles")
    public Map<?,?> write(@RequestBody ArticleDTO article){
        var map = px.hashmap();
        map.put("message", px.message(articleService.write(article)));

        
        return map;
    }
    @GetMapping("/articles")
    public Map<?,?> list(){
        printer.accept("---- 목록 진입 ----");
        var map = px.hashmap();
        List<ArticleDTO> l = articleService.list();
        System.out.println("목록 수: "+l.size());
        map.put("list", l);
        map.put("count", articleService.count());
        return map;
    }
    @GetMapping("/articles/{artNum}/count")
    public Map<?,?> increaseCount(@PathVariable String artNum){
        var map = px.hashmap();
        int result = articleService.increaseCount(artNum);
        map.put("message", (result == 1) ? "SUCCESS": "FAILURE");
        return map;
    }
    @GetMapping("/articles/{artNum}")
    public ArticleDTO detail(@PathVariable String artNum){
        return articleService.getArticleById(artNum);
    }
    @GetMapping("/articles/crawling/{site}")
    public Map<?,?> crawling(@PathVariable String site){
        var map = px.hashmap();
        var count = articleService.count();
        if(count == 0){
            switch(site){
                case "bugs":
                map.put("count", articleService.crawling("https://music.bugs.co.kr/recomreview?&order=listorder&page=2"));
                break;
            }
        }else{
            map.put("count", count);
        }
        return map;
    }
    @PutMapping("/articles")
    public Map<?,?> update(@RequestBody ArticleDTO article){
        var map = px.hashmap();
        map.put("message", (articleService.update(article) == 1) ? "SUCCESS": "FAILURE");
        return map;
    }
    @DeleteMapping("/articles")
    public Map<?,?> delete(@RequestBody ArticleDTO article){
        printer.accept("삭제할 ID >>> "+article.getArtNum());
        var map = px.hashmap();
        map.put("message", (articleService.delete(article) == 1) ? "SUCCESS": "FAILURE");
        return map;
    }
}
