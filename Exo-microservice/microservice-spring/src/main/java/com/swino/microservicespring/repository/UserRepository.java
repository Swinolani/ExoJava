package com.swino.microservicespring.repository;

import com.swino.microservicespring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
