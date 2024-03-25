package org.myungkeun.spring_blog.controllers;

import lombok.RequiredArgsConstructor;
import org.myungkeun.spring_blog.payload.PostDto;
import org.myungkeun.spring_blog.payload.PostsResponseDto;
import org.myungkeun.spring_blog.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto
    ) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(
            @PathVariable(name = "id") Long id
    ) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<PostsResponseDto> getAllPost(
            int pageNo,
            int pageSize,
            String sortBy,
            String sortDir
    ) {
        return new ResponseEntity<>(postService.getAllPost(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(
            @RequestBody PostDto postDto,
            @PathVariable(name = "id") Long id
    ) {
        return new ResponseEntity<>(postService.updatePostById(id, postDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(
            @PathVariable(name = "id") Long id
    ) {
        return new ResponseEntity<>(postService.deletePostById(id), HttpStatus.OK);
    }
}
