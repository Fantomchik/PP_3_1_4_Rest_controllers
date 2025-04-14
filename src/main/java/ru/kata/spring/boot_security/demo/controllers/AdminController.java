package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entityes.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showAdminPage(Principal principal, Model model) {
        User authUser = userService.findUserByUsername(principal.getName());
        model.addAttribute("authUser", authUser);
        return "admin";
    }

    @GetMapping("/new")
    public String showNewUserForm(Principal principal, Model model) {
        User authUser = userService.findUserByUsername(principal.getName());
        model.addAttribute("authUser", authUser);
        return "admin";
    }
}
