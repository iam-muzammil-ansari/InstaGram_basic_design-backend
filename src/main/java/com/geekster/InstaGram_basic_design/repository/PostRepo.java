package com.geekster.InstaGram_basic_design.repository;

import com.geekster.InstaGram_basic_design.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
}
