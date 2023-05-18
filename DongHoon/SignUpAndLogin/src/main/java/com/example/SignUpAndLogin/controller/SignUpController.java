package com.example.SignUpAndLogin.controller;


import com.example.SignUpAndLogin.model.SignUpUserReq;
import com.example.SignUpAndLogin.service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping("/sign-up")
    public String showSignUpPage() {
        return "/sign-up";
    }

    @PostMapping("/sign-up")
    public String SignUp(@RequestParam("name") @Valid String name,
                         @RequestParam("age") @Valid String age,
                         @RequestParam("email") @Valid String email,
                         @RequestParam("password") @Valid String password)
    {

        try{
            SignUpUserReq signUpUserReq = new SignUpUserReq(name , age, email, password);
            this.signUpService.SignUp(signUpUserReq);
        }catch (Exception e) {
            return e.getMessage();
        }
        return "/index";
    }
}
