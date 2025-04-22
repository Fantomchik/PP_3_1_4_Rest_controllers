package ru.kata.spring.boot_security.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RoleRestController {

    @GetMapping
    public String getPage(){
        return "main-page";
    }
}
