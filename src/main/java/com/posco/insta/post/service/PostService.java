package com.posco.insta.post.service;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import io.swagger.models.auth.In;

import java.util.List;

public interface PostService {

    List<PostDto> getPosts();

    List<SelectPostJoinUserDto> getPostMyPost(PostDto postDto);

    Integer deletePost(PostDto postDto);

    List<SelectPostJoinUserDto> getOtherPost(PostDto postDto);

    Integer updateMyPost(PostDto postDto);

    Integer postPost(PostDto postDto);

    List<SelectPostJoinUserDto> getPostById(PostDto postDto);

    List<SelectPostJoinUserDto> getPostByKey(PostDto postDto);

    List<SelectPostJoinUserDto> getMatFollow(PostDto postDto);
}
