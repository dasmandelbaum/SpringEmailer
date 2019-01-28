package com.mandelbaum.emailer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class EmailerController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to spring boot emailer";
    }

    @RequestMapping("/send")
    public String oops() {
        
        return "email sent.";
    }
}
