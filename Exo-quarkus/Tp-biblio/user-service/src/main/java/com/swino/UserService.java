package com.swino;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.listAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findByIdOptional(id);
    }

    @Transactional
    public UserEntity addUser(UserEntity user) {
        userRepository.persist(user);
        return user;
    }

    @Transactional
    public UserEntity updateUser(UserEntity user) {
        return userRepository.getEntityManager().merge(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
