package com.example.springbootvue.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo implements Serializable {
    private String seq;
    private String title;
    private String author;
    private String create_dt;
    private String contents;
    private String update_dt;
    private String status;
}
