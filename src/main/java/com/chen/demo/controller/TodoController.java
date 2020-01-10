package com.chen.demo.controller;

import com.chen.demo.dto.Todo;
import com.chen.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
@PreAuthorize("hasRole('USER')")
public class TodoController {

    private TodoService service;

    @Autowired
    public TodoController(TodoService service){
        this.service = service;
    }

    @GetMapping()
    public List<Todo> getAllTodos(@RequestHeader(value = "username") String username) {
        return service.findAll(username);
    }

    @PostMapping()
    Todo addTodo(@RequestBody Todo addedTodo) {
        return service.addTodo(addedTodo);
    }

    @GetMapping(value = "/{id}")
    public Optional<Todo> getTodo(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    Todo updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {
        updatedTodo.setId(id);
        return service.update(updatedTodo);
    }

    @DeleteMapping(value = "/{id}")
    Optional<Todo> removeTodo(@PathVariable String id) {
        return service.deleteTodo(id);
    }
}