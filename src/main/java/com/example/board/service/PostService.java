package com.example.board.service;

import com.example.board.domain.Post;
import com.example.board.repostory.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public class PostService {

    @Autowired
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public String createPost(Post post) {
        String id = UUID.randomUUID().toString();
        post.setId(id);
        Date current = new Date();
        post.setCreatedDate(current);
        post.setUpdatedDate(current);
        postRepository.save(post);
        return id;
    }

    public void updatePost(String id, Post form) {
        Optional<Post> post = postRepository.findById(id);
        post.ifPresent(s->{
            s.setUpdatedDate(new Date());
            s.setBody(form.getBody());
            s.setTitle(form.getTitle());
            s.setAuthor(form.getAuthor());
        });

        postRepository.saveAndFlush(post.orElse(new Post()));
    }

    public void deletePost(String id){
        Optional<Post> post = postRepository.findById(id);
        post.ifPresent(s->{
            s.setDeleted(true);
            s.setUpdatedDate(new Date());
        });
        postRepository.saveAndFlush(post.orElse(new Post()));
    }

    public List<Post> getAllPost(){
        return postRepository.findByDeletedFalseOrderByUpdatedDateDesc();
//                .stream()
//                .filter(post -> !post.isDeleted())
//                .toList();
    }

    public Post findPost(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(new Post());
    }


}
