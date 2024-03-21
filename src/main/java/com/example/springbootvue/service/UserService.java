package com.example.springbootvue.service;

import com.example.springbootvue.entity.UserEntity;
import com.example.springbootvue.entity.UserRepository;
import com.example.springbootvue.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor    // 생성자 자동 생성
@Service
public class UserService {

    private final UserRepository userRepository;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserEntity createUser(UserVo userVo) {
        UserEntity entity = UserEntity.builder()
                .id(userVo.getId())
                .password(passwordEncoder.encode(userVo.getPassword()))
                .name(userVo.getName())
                .phone(userVo.getPhone())
                .reg_date(localTime)
                .build();
        return userRepository.save(entity);
    }
}
