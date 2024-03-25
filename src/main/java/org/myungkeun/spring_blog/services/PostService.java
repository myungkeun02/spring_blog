package org.myungkeun.spring_blog.services;

import org.myungkeun.spring_blog.payload.PostDto;
import org.myungkeun.spring_blog.payload.PostsResponseDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto getPostById(Long id);
    PostDto updatePostById(Long id, PostDto postDto);
    PostsResponseDto getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    String deletePostById(Long id);
}
