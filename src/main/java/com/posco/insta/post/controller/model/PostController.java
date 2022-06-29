package com.posco.insta.post.controller.model;

import com.posco.insta.aspect.TokenRequired;
import com.posco.insta.config.SecurityService;
import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.service.PostServiceImpl;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@TokenRequired
public class PostController {

    @Autowired
    PostServiceImpl postService;
    @Autowired
    SecurityService securityService;
    @Autowired
    PostDto postDto=new PostDto();
    @GetMapping("/")
    public List<PostDto> getPost(){
        return postService.getPosts();
    }

    @GetMapping("/my")

    public List<SelectPostJoinUserDto> getPostMyPost(){

        postDto.setUserId(securityService.getIdByToken());
        return postService.getPostMyPost(postDto);
    }

    @DeleteMapping("/{id}")
    public Integer deleteMyPost(@PathVariable String id){
        postDto.setId(Integer.valueOf(id));
        postDto.setUserId(securityService.getIdByToken());

        return postService.deletePost(postDto);
    }

    @GetMapping("/other")
    public List<SelectPostJoinUserDto> getOtherPost(){

        postDto.setUserId(securityService.getIdByToken());
        return postService.getOtherPost(postDto);
    }

    @PutMapping("/{id}")
    public Integer updateMyPost(@RequestBody PostDto postDto, @PathVariable String id){
        postDto.setUserId((securityService.getIdByToken()));
        postDto.setId(Integer.parseInt(id));

        return postService.updateMyPost(postDto);
    }

    @PostMapping("/")
    public Integer postPost(@RequestBody PostDto postDto){
        postDto.setUserId(securityService.getIdByToken());
        return postService.postPost(postDto);
    }

    @GetMapping("/{id}")
    public List<SelectPostJoinUserDto> getPostsById(@PathVariable String id){
        postDto.setId(Integer.parseInt(id));
        return postService.getPostById(postDto);
    }
    @GetMapping("/key/{key}")
    public List<SelectPostJoinUserDto> getPostsLikeKey(@PathVariable String key){
        postDto.setContent(key);
        return postService.getPostByKey(postDto);

    }

    @GetMapping("/following")
    public List<SelectPostJoinUserDto> getPostsByMyFollowing(){
        postDto.setUserId(securityService.getIdByToken());
        return postService.getMatFollow(postDto);
    }
}
