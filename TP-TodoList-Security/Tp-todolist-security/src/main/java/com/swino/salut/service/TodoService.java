package com.swino.salut.service;

import com.swino.salut.entity.Todo;
import com.swino.salut.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(int id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(int id, Todo todoDetails) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setCompleted(todoDetails.isCompleted());
            todo.setUser(todoDetails.getUser());
            return todoRepository.save(todo);
        } else {
            return null;
        }
    }

    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }
}
