package com.example.springbootvue.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    void test_user() {
        String encPassword = passwordEncoder.encode("test_password");

        UserEntity entity = UserEntity.builder()
                .id("test_user3")
                .password(encPassword)
                .name("테스트 유저3")
                .phone("010-1234-0000")
                .build();
        UserEntity savedUser = userRepository.save(entity);

        assertThat(entity.getId()).isEqualTo(savedUser.getId());
    }

}