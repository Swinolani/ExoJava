package com.swino.microservicespring.service;

import com.swino.microservicespring.entity.UserEntity;
import com.swino.microservicespring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }


    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public UserEntity updateUser(Long id, UserEntity updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUseName(updatedUser.getUseName());
                    user.setUseEmail(updatedUser.getUseEmail());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}