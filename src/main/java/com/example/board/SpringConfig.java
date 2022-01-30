package com.example.board;

import com.example.board.repostory.PostRepository;
import com.example.board.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final PostRepository postRepository;

    public SpringConfig(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Bean
    public PostService postService(){
        return new PostService(postRepository);
    }
}
