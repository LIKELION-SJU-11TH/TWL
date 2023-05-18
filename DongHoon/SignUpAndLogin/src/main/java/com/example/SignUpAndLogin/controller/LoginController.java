package com.example.SignUpAndLogin.controller;

import com.example.SignUpAndLogin.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage()
    {
        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password")String password) {
        try{
            this.loginService.findUser(email, password);
        }catch(Exception e)
        {
            return e.getMessage();
        }
        log.info(email);
        log.info(password);
        return "/index";
    }
}
