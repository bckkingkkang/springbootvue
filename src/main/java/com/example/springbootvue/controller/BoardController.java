package com.example.springbootvue.controller;


import com.example.springbootvue.entity.BoardEntity;
import com.example.springbootvue.service.BoardService;
import com.example.springbootvue.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public List<BoardVo> boardList() {


        return boardService.getBoardList();
    }

    @GetMapping("/board/{seq}")
    public BoardVo getBoard(@PathVariable String seq) {
        return boardService.getBoard(seq);
    }

    @PostMapping("/board")
    public BoardEntity createBoard(@RequestBody BoardVo boardVo) {
        return boardService.createBoard(boardVo);
    }

    @PatchMapping("/board")
    public BoardEntity updateBoard(@RequestBody BoardVo boardVo) {

        return boardService.updateBoard(boardVo);
    }

    @PatchMapping("/board/delete")
    public BoardEntity deleteBoard(@RequestBody BoardVo boardVo) {
        return boardService.deleteBoard(boardVo);
    }


}
