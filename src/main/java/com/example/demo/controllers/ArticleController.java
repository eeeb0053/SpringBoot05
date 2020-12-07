package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.services.ArticleService;
import com.example.demo.utils.Printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired ArticleService userService;
    @Autowired Printer printer;

}
