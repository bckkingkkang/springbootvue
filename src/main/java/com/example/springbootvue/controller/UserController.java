package com.example.springbootvue.controller;

import com.example.springbootvue.entity.BoardEntity;
import com.example.springbootvue.entity.UserEntity;
import com.example.springbootvue.service.UserService;
import com.example.springbootvue.vo.BoardVo;
import com.example.springbootvue.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor    // 생성자 자동 생성
public class UserController {

    @Autowired
    UserService userService;

    /* 로그인 화면 */
    @RequestMapping("member/login")
    private String Login() {
        return "member/login";
    }

    /* 회원 가입 화면 */
    @GetMapping("member/signup")
    public String SingupForm() {
        return "member/signup";
    }

    /* 회원 가입 진행 */
    @PostMapping("member/signup")
    public void Signup(UserVo userVo) {
        userService.createUser(userVo);
    }
    /*@PostMapping("member/signup")
    public UserEntity Signup(@RequestBody UserVo userVo) {
        return userService.createUser(userVo);
    }*/
}
