package com.example.restfullwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
public class User {

    @Id
    @GeneratedValue
    private  Integer id;

    @Size(min = 2, message = "이름은 최소 2글자 이상을 입력해 주세요") // 최소 2글자
    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요")
    private  String name;

    @Past // 과거형은 못 쓴다 .
    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요")
    private Date joinData;

    @ApiModelProperty(notes = "사용자 패스워드를 입력해 주세요")
    private  String password;

    @ApiModelProperty(notes = "사용자 주민번호를 입력해 주세요")
    private  String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;


    public User(int id, String name, Date joinDate, String password, String ssn) {
        this.id= id;
        this.name = name;
        this.joinData= joinDate;
        this.password  = password;
        this.ssn = ssn;
    }
}
