package com.example.restfullwebservice.user;
//http status code
//200 -> ok
//400 -> client가 잘못할 경우
//500 -> server 측의 잘못

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //404 에러
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
