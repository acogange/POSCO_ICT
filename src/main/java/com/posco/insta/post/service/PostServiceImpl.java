package com.posco.insta.post.service;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.repository.PostMapper;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostMapper postMapper;
    @Override
    public List<PostDto> getPosts(){
        return postMapper.getPosts();
    }

    @Override
    public List<SelectPostJoinUserDto> getPostMyPost(PostDto postDto) {
        return postMapper.findPostByUserId(postDto);
    }

    @Override
    public Integer deletePost(PostDto postDto) {
        return postMapper.deletePostByUserIdAndId(postDto);
    }
    @Override
    public List<SelectPostJoinUserDto> getOtherPost(PostDto postDto) {
        return postMapper.findPostByNotUserId(postDto);
    }

    @Override
    public Integer updateMyPost(PostDto postDto) {
        return postMapper.updatePostByUserId(postDto);
    }

    @Override
    public Integer postPost(PostDto postDto) {
        return postMapper.postPost(postDto);
    }
    @Override
    public List<SelectPostJoinUserDto> getPostById(PostDto postDto) {
        return postMapper.getPostById(postDto);
    }

    @Override
    public List<SelectPostJoinUserDto> getPostByKey(PostDto postDto) {
        return postMapper.getPostByKey(postDto);
    }
    @Override
    public List<SelectPostJoinUserDto> getMatFollow(PostDto postDto) {
        return postMapper.getMatFollow(postDto);
    }

}
