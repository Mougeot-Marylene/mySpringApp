package net.codejava.my_spring_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myControler {

    @GetMapping("/hello")
    public String hello() {
        return "hello, spring boot";
    }
}
