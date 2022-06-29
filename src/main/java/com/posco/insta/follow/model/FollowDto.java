package com.posco.insta.follow.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FollowDto {
private Integer follower;
private Integer following;

}
