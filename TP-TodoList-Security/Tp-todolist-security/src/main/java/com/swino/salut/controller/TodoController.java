package com.swino.salut.controller;

import com.swino.salut.entity.Todo;
import com.swino.salut.entity.User;
import com.swino.salut.service.TodoService;
import com.swino.salut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @PostMapping("/createTodo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        System.out.println(todo.toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = (User) userService.loadUserByUsername(userEmail);

        if (user != null) {
            todo.setUser(user);
            Todo savedTodo = todoService.createTodo(todo);
            return ResponseEntity.ok(savedTodo);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/listTodos")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }
}
