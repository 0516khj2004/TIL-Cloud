package com.example.restfullwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private  Integer id;

    private  String description;

    // user(M) : post(s) = 1: 0~n

    @ManyToOne(fetch = FetchType.LAZY)//지연 로딩 방식 (post 매핑할떄 원하는 데이터를 가져온다)
    @JsonIgnore
    private  User user;

}
