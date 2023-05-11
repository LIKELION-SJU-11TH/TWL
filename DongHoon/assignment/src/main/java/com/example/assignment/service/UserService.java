package com.example.assignment.service;

import com.example.assignment.Repository.UserRepository;
import com.example.assignment.entity.User;
import com.example.assignment.model.GetUserRes;
import com.example.assignment.model.SignUpUserReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 유저 생성
     * @param signUpUserReq
     */
    public void createUser(SignUpUserReq signUpUserReq) {


        User user = User.builder()
                .age(signUpUserReq.getAge())
                .name(signUpUserReq.getName())
                .email(signUpUserReq.getEmail())
                .password(signUpUserReq.getPassword())
                .build();

        userRepository.save(user);
    }

    /**
     * 유저 전체 조회
     */
    public List<GetUserRes> getUsers() {
        List<User> userList = userRepository.findAll();

        List<GetUserRes> userRes = new ArrayList<>();
        for (User user : userList) {
            GetUserRes getUserEntity = new GetUserRes(user);
            userRes.add(getUserEntity);
        }

        /*
        간단한 방법.
        List<GetUserRes> userRes = userList.stream().map(GetUserRes::new).collect(Collectors.toList());
        */

        return userRes;
    }
    public GetUserRes getUserRes (int id)
    {
        Optional<User> user = this.userRepository.findById((long) id);
        GetUserRes findUser= new GetUserRes(user.get());
        return findUser;
    }
    /**
     * 인덱스로 유저 조회
     * 한번 구현해 보세요
     *
     * 1. user_id로 user 조회 (UserRepository의 findById 이용)
     * 2. User를 GetUserRes로 변환
     * 3. GetUserRes 반환
     *
     * findById로 User 조회 시 Optional<User>로 반환 -> User를 빼오는 방법 찾아보세요.
     */

}
