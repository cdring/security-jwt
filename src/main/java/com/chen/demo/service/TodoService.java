package com.chen.demo.service;

import com.chen.demo.dto.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Todo addTodo(Todo todo);
    Optional<Todo> deleteTodo(String id);
    List<Todo> findAll(String username);
    Optional<Todo> findById(String id);
    Todo update(Todo todo);
}