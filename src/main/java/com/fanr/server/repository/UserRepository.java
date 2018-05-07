package com.fanr.server.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanr.server.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

  boolean existsByUsername(String username);

  User findByUsername(String username);

  @Transactional
  void deleteByUsername(String username);

}
