package com.example.restfullwebservice.helloworld;
//lombok - get,set을 자동으로  만들어주는 어노테이션

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HelloWorldBean {

    private String message;

}
