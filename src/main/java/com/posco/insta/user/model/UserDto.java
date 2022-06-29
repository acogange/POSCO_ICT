package com.posco.insta.user.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data //getter, setter, tostring 등 집합체
@Component
public class UserDto {
    private Integer id;
    private String password;
    private String userId;
    private String img;
    private String name;


}
