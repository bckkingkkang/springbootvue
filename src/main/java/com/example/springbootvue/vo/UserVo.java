package com.example.springbootvue.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private String idx;
    private String id;
    private String password;
    private String name;
    private String phone;
    private String reg_date;
}
