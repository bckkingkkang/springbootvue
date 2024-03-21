package com.example.springbootvue.controller;

import com.example.springbootvue.service.BoardService;
import com.example.springbootvue.vo.BoardVo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class TestController {

    private final BoardService boardService;

    @RequestMapping("/")
    private String HomeTest() {
        return "home";
    }

    @RequestMapping("/main")
    private String MainTest() {
        return "main";
    }

    @GetMapping("/list")
    private ModelAndView list(ModelAndView mav ) {
        List<BoardVo> board_list = boardService.getBoardList();

        mav.addObject("board_list", board_list);

        return mav;
    }

}
