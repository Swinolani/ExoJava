package com.swino.salut.controller;

import com.swino.salut.entity.User;
import com.swino.salut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/setting")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private UserService userService;

    @DeleteMapping("/users/{mail}")
    public ResponseEntity<String> deleteUserByEmail(@PathVariable String mail) {
        User user = (User) userService.loadUserByUsername(mail);
        if (user != null) {
            userService.deleteUser(user.getUserId());
            return ResponseEntity.ok("Utilisateur supprimé avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/admins")
    public ResponseEntity<List<User>> getAllAdmins() {
        List<User> admins = userService.getAllUsersByRole("ADMIN");
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsersByRole("USER");
        return ResponseEntity.ok(users);
    }
}
