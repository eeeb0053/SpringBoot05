package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;

@Component("px")
public class Proxy {
    public int integer(String t){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(t);
    }
    public String string(Object t){
        Function<Object, String> f = String::valueOf;
        return f.apply(t);
    }
    public boolean equals(String t1, String t2){
        BiPredicate<String, String> p = String::equals;
        return p.test(t1, t2);
    }
    public int random(int begin, int end){
        BiFunction<Integer, Integer, Integer> f = (t, u) -> (int)(Math.random() * (u - t)) + t;
        return f.apply(begin, end);
    }
    public int[] array(int size){
        Function<Integer, int[]> f = int[]::new;
        return f.apply(size);
    }
    public Map<String, Object> hashmap(){
        Supplier<Map<String, Object>> s = HashMap::new;
        return s.get();
    }
}