package com.example.board.service;


import com.example.board.domain.Post;
import com.example.board.repostory.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PostServiceTest {


    @Autowired PostService postService;
    @Autowired PostRepository postRepository;


    @Test
    void create(){
        //given
        Post post = new Post();
        post.setAuthor("용우");
        post.setTitle("제목");
        post.setBody("내용");

        //when
        String id = postService.createPost(post);

        //then
        Post findpost = postService.findPost(id);
        Assertions.assertThat(findpost.getTitle()).isEqualTo(post.getTitle());
    }
}
