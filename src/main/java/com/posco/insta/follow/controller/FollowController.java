package com.posco.insta.follow.controller;

import com.posco.insta.aspect.TokenRequired;
import com.posco.insta.config.SecurityService;
import com.posco.insta.follow.model.FollowDto;
import com.posco.insta.follow.service.FollowServiceImpl;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@TokenRequired
@RequestMapping("follow")
public class FollowController {
    @Autowired
    FollowDto followDto;
    @Autowired
    SecurityService securityService;
    @Autowired
    FollowServiceImpl followService;
    @GetMapping("/my/follower")
    @Operation(description = "내 follower 받아옴")
    public List<FollowDto> getMyFollower(){
        followDto.setFollowing(securityService.getIdByToken());
        return followService.getMyFollower(followDto);
    }

    @GetMapping("/follower/{id}")
    @Operation(description = "follower 받아옴")
    public List<FollowDto> getFollowerById(@PathVariable String id){

        followDto.setFollowing(Integer.valueOf(id));
        return followService.getFollower(followDto);
    }
    @GetMapping("/my/following")
    @Operation(description = "내 following 받아옴")
    public List<FollowDto> getMyFollowing(){
        followDto.setFollowing(securityService.getIdByToken());
        return followService.getMyFollowing(followDto);
    }

    @GetMapping("/following/{id}")
    @Operation(description = " following 받아옴")
    public List<FollowDto> getFollowingById(@PathVariable String id){

        followDto.setFollowing(Integer.valueOf(id));
        return followService.getFollowing(followDto);
    }

//    @GetMapping("/my/follower")
//
//    public FollowDto getFollowerByOne(@PathVariable String id){
//
//        followDto.setFollowing(Integer.valueOf(id));
//        return  followService.getFollowerByOne(followDto);
//    }

    @PostMapping("/{id}")
    public Integer postFollow(@PathVariable String id){
        followDto.setFollowing(securityService.getIdByToken());
        followDto.setFollower(Integer.valueOf(id));
        return followService.insertFollow(followDto);
    }

    @DeleteMapping ("/{id}")
    public Integer deleteFollow(@PathVariable String id){
        followDto.setFollowing(securityService.getIdByToken());
        followDto.setFollower(Integer.valueOf(id));
        return followService.deleteFollow(followDto);
    }


}
