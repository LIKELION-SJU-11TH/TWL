package com.dan.api_example.controller;

import com.dan.api_example.model.GetLogin;
import com.dan.api_example.model.GetUserRes;
import com.dan.api_example.model.SignUpUserReq;
import com.dan.api_example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public String checkUser(@RequestBody GetLogin getLogin){
        if(userService.checkUser(getLogin.getEmail(),getLogin.getPassword())){
            return "로그인 성공";
        }
        else{
            return "로그인 실패";
        }

    }
    @PostMapping("/signup")
    @ExceptionHandler(RuntimeException.class)
    public String createUser(@RequestBody @Valid SignUpUserReq signUpUserReq) {
        if(userService.checkEmail(signUpUserReq.getEmail())){
            return "이미 가입한 이메일 입니다.";
        }
        else{
            userService.createUser(signUpUserReq);
            return "회원가입이 완료되었습니다.";
        }
    }

    @GetMapping("/")
    public List<GetUserRes> getUser() {
        List<GetUserRes> getUserRes = userService.getUsers();
        return getUserRes;
    }

    @GetMapping("/read-one")
    public GetUserRes getUserOne(@RequestParam("id") int id){
        GetUserRes getUserRes=userService.getUser(id);
        return getUserRes;
    }
    /**
     * 단일 유저 조회
     * 구현해 보세요
     *
     * @RequestParam으로 userId 받아와서 조회
     */
}
