package com.dan.api_example.service;

import com.dan.api_example.entity.User;
import com.dan.api_example.model.GetUserRes;
import com.dan.api_example.model.SignUpUserReq;
import com.dan.api_example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //의존성 주입
public class UserService {

    private final UserRepository userRepository;

    /**
     * 유저 생성
     * @param signUpUserReq
     */


    //비밀번호 생성
    public static String getEncrypt(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); //"SHA256" 인스턴스 생성
            md.update(plainText.getBytes()); //SaltedPlainText는 비밀번호 + salt이고 이것을 해싱하는것
            byte[] byteData = md.digest(); //바이트 배열로 해쉬를 반환.

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; ++i) {
                String hex = Integer.toHexString(255 & byteData[i]); // 각 바이트마다 Hex값으로 변환
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception var7) {
            var7.printStackTrace();
            throw new RuntimeException();
        }
    }



    public boolean checkEmail(String email){
        List<User> userList=userRepository.findAll();

        for(User user: userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }


    public void createUser(SignUpUserReq signUpUserReq) {

        User new_user = User.builder()
                .age(signUpUserReq.getAge())
                .name(signUpUserReq.getName())
                .email(signUpUserReq.getEmail())
                .password(UserService.getEncrypt(signUpUserReq.getPassword()))
                .build();


        userRepository.save(new_user);
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
    public GetUserRes getUser(int id){
        Optional<User> user=userRepository.findById((long)id);
        //이 과정도 builder를 만들면 가능?
        GetUserRes getUserRes=new GetUserRes(
            user.get()
        );

        return getUserRes;
    }



    /*
    * 로그인 구형
    * */
    public boolean checkUser(String email, String password){
        Optional<User> user=userRepository.findByEmail(email);

        if(user.get().getPassword().equals(getEncrypt(password))){
            return true;
        }
        else{
            return false;
        }
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
