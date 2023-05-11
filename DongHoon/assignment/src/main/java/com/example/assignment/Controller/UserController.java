package com.example.assignment.Controller;

import com.example.assignment.entity.User;
import com.example.assignment.model.GetUserRes;
import com.example.assignment.model.SignUpUserReq;
import com.example.assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String createUser(@RequestBody SignUpUserReq signUpUserReq) {
        userService.createUser(signUpUserReq);
        return "ok";
    }

    @GetMapping("/")
    public List<GetUserRes> getUser() {
        List<GetUserRes> getUserRes = userService.getUsers();
        return getUserRes;
    }

    @GetMapping("{id}")
    public GetUserRes getUserById(@RequestParam("id") int id)
    {
        return this.userService.getUserRes(id);
    }



    /**
     * 단일 유저 조회
     * 구현해 보세요
     *
     * @RequestParam으로 userId 받아와서 조회
     */
}
