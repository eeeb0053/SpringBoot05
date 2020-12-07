package com.example.demo.impls;

import com.example.demo.repositories.ArticleRepository;
import com.example.demo.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired ArticleRepository userRepository;
}
