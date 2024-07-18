package com.swino.salut.service;

import com.swino.salut.config.jwt.JwtTokenProvider;
import com.swino.salut.entity.User;
import com.swino.salut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User updateUser(int id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setMail(userDetails.getMail());
            user.setPassword(userDetails.getPassword());
            user.setEnabled(userDetails.isEnabled());
            user.setRole(userDetails.getRole());
            user.setListTodos(userDetails.getListTodos());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsersByRole(String roleName) {
        return userRepository.findByRole(roleName);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByMail(email).orElseThrow(() -> new UsernameNotFoundException(" User Not Found "));
    }
    public boolean checkUserNameExists(String email) {
        return userRepository.findByMail(email).isPresent();
    }

    public String generateToken(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;

    }
    public boolean verifyUser(String email, String password) {
        return userRepository.findByMail(email).map(user -> passwordEncoder.
                matches(password, user.getPassword())).orElseThrow(() -> new UsernameNotFoundException(" User Not Found "));
    }
    public boolean createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
