package com.example.restfulapi.helloworld;

import com.example.restfulapi.HellwoWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //Get
    // /hello-world
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // alt + enter
    @GetMapping(path = "/hello-world-bean")
    public HellwoWorldBean helloWorldBean(){
        return new HellwoWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HellwoWorldBean helloWorldBean(@PathVariable String name){
        return new HellwoWorldBean(String.format("Hello World, %s", name));
    }
}
