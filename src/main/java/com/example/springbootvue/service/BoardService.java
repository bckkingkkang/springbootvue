package com.example.springbootvue.service;

import com.example.springbootvue.entity.BoardEntity;
import com.example.springbootvue.entity.BoardRepository;
import com.example.springbootvue.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    /* 게시글 목록 */
    public List<BoardVo> getBoardList() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardVo> Vos = new ArrayList<>();

        for(BoardEntity entity : boardEntities) {
            BoardVo vo = BoardVo.builder()
                    .seq(entity.getSeq())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .author(entity.getAuthor())
                    .create_dt(entity.getCreate_dt())
                    .update_dt(entity.getUpdate_dt())
                    .status(entity.getStatus())
                    .view(entity.getView())
                    .build();
            /* 삭제된 게시글 X */
            if(vo.getStatus().equals("N")) {
                Vos.add(vo);
            }

        }

        return Vos;
    }

    /* 게시글 상세 */
    public BoardVo getBoard(String seq) {
        BoardEntity entity = boardRepository.findById(seq).orElseThrow(()-> new RuntimeException(""));
        return BoardVo.builder()
                .seq(entity.getSeq())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .author(entity.getAuthor())
                .create_dt(entity.getCreate_dt())
                .update_dt(entity.getUpdate_dt())
                .build();
    }

    /* 게시글 등록 */
    public BoardEntity createBoard(BoardVo boardVo) {
        BoardEntity entity = BoardEntity.builder()
                .title(boardVo.getTitle())
                .contents(boardVo.getContents())
                .author(boardVo.getAuthor())
                .create_dt(String.valueOf(LocalDateTime.now()))
                .status("N")
                .build();
        return boardRepository.save(entity);
    }

    /* 게시글 수정 */
    public BoardEntity updateBoard(BoardVo boardVo) {
        BoardEntity entity = boardRepository.findById(boardVo.getSeq()).orElseThrow(()-> new RuntimeException(""));
        entity.setTitle(boardVo.getTitle());
        entity.setContents(boardVo.getContents());
        entity.setUpdate_dt(String.valueOf(LocalDateTime.now()));

        return boardRepository.save(entity);
    }

    /* 게시글 삭제 */
    public BoardEntity deleteBoard(BoardVo boardVo) {
        BoardEntity entity = boardRepository.findById(boardVo.getSeq()).orElseThrow(()->new RuntimeException(""));
        entity.setUpdate_dt(String.valueOf(LocalDateTime.now()));
        entity.setStatus("Y");
        return boardRepository.save(entity);
    }

}
