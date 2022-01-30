package com.example.board.repostory;

import com.example.board.domain.Post;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//public class JpaPostRepository implements PostRepository{
public class JpaPostRepository{
    private final EntityManager em;

    public JpaPostRepository(EntityManager em) {
        this.em = em;
    }


//    @Override
    public Post save(Post post) {
        em.persist(post);
        return post;
    }

//    @Override
    public Post updatePost(Post post) {

        return null;
    }

//    @Override
    public void deletePost(String id) {

    }

//    @Override
    public List<Post> findAll() {
        return null;
    }
}
