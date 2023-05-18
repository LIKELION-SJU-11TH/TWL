package com.example.SignUpAndLogin.service;

import com.example.SignUpAndLogin.entity.User;
import com.example.SignUpAndLogin.model.GetUserRes;
import com.example.SignUpAndLogin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class LoginService implements Service{

    private final UserRepository userRepository;

    public GetUserRes findUser(String email,
                               String password)throws Exception {
        Optional<User> userOptional = this.userRepository.findByEmail(email);
        if(userOptional.isEmpty())
        {
            Exception e = new Exception("잘못된 이메일입니다.");
            throw e;
        }

        User user = userOptional.get();
        String checkPassword = user.getPassword();
        if(checkPassword.equals(password)){
            GetUserRes getUserRes = new GetUserRes(user);
            return getUserRes;
        }
        else
        {
            Exception e = new Exception("잘못된 비밀번호입니다.");
            throw e;
        }

    }
}
