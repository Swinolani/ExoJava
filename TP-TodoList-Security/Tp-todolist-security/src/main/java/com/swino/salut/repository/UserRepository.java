package com.swino.salut.repository;

import com.swino.salut.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByMail(String email);
    List<User> findByRole(String roleName);
}
