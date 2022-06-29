package com.posco.insta;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("/")
    public String Test(){
        return "test1";
    }

//    @GetMapping("/{id}")
//    public String testId(@PathVariable String id){
//        return id;
//    }
//
//    @PostMapping("/")
//    public String testPost(){
//        return "hello world";
//    }
//
//    @DeleteMapping("/{id}")
//    public String testDelete(@PathVariable String id){
//        return "hello world" + id;
//    }
//
//    @PutMapping("/")
//    public String testPut(){
//        return "hello world";
//    }

}

