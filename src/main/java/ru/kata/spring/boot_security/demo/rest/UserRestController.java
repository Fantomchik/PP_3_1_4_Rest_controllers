package ru.kata.spring.boot_security.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entityes.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(Principal principal) {
        return new ResponseEntity<>(userService.findUserByUsername(principal.getName()), HttpStatus.OK);
    }
}