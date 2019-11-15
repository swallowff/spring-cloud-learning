package cn.swallow.cloudlearn.securityoauth2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hi")
    public String hi(String name){
        return "hi , " + name;
    }


}