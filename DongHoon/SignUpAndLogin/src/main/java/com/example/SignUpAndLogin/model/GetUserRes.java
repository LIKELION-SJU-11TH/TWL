package com.example.SignUpAndLogin.model;

import com.example.SignUpAndLogin.entity.User;
import lombok.Getter;

@Getter
public class GetUserRes {
    private String email;
    private String name;
    private String age;

    public GetUserRes(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public GetUserRes() {
    }
}
