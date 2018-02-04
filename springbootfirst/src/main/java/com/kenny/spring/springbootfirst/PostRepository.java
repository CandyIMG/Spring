package com.kenny.spring.springbootfirst;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findById( String id );
    List<Post> findByTitle( String title );
    List<Post> findByContent(String content );
}
