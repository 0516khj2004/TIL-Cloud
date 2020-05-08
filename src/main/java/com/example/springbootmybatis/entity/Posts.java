package com.example.springbootmybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Posts{
    private int id;
    private String user_id;
    private String title;
    private String contents;
    private byte del_yn;
    private Date createAt;

    public Posts(String user_id, String title, String contents) {
        this.user_id = user_id;
        this.title = title;
        this.contents = contents;
    }
}
