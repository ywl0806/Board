package com.example.board.repostory;

import com.example.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    public Optional<Post> findById(String id);
    public List<Post> findByDeletedFalseOrderByUpdatedDateDesc();
}
