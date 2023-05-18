package com.example.SignUpAndLogin.service;


import com.example.SignUpAndLogin.entity.User;
import com.example.SignUpAndLogin.model.SignUpUserReq;
import com.example.SignUpAndLogin.repository.UserRepository;
import com.example.SignUpAndLogin.util.SHA256;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class SignUpService  implements Service {

    private final UserRepository userRepository;


    public void SignUp(SignUpUserReq signUpUserReq) throws Exception {
        String plainPw = signUpUserReq.getPassword();

        String encryptPw = SHA256.encrypt(plainPw);

        Optional<User> optionalUser = userRepository.findByEmail(signUpUserReq.getEmail());
        if (optionalUser.isPresent()) {
            Exception e = new Exception("이미 가입된 이메일입니다");
            throw e;
        }

        User user = User.builder().
                age(signUpUserReq.getAge()).
                name(signUpUserReq.getName()).
                email(signUpUserReq.getEmail()).
                password(signUpUserReq.getPassword()).build();
        user.setEncrpyt();
        userRepository.save(user);
    }

}
