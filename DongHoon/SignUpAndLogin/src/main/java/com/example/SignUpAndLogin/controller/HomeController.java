package com.example.SignUpAndLogin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    public String home()
    {
        System.out.println("home controller activated");
        return "index";
    }
}
