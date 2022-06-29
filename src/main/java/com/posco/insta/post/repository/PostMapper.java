package com.posco.insta.post.repository;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PostMapper {
    List<PostDto> getPosts();

    List<SelectPostJoinUserDto> findPostByUserId(PostDto postDto);
    Integer deletePostByUserIdAndId(PostDto postDto);

    List<SelectPostJoinUserDto> findPostByNotUserId(PostDto postDto);

    Integer updatePostByUserId(PostDto postDto);

    Integer postPost(PostDto postDto);
    List<SelectPostJoinUserDto> getPostById(PostDto postDto);
    List<SelectPostJoinUserDto> getPostByKey(PostDto postDto);

    List<SelectPostJoinUserDto> getMatFollow(PostDto postDto);
}
