package com.geekster.InstaGram_basic_design.repository;

import com.geekster.InstaGram_basic_design.model.AuthenticationToken;
import com.geekster.InstaGram_basic_design.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByToken(String token);
    AuthenticationToken findFirstByUser(User user);
}