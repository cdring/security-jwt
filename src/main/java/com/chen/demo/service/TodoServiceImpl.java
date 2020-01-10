package com.chen.demo.service;

import com.chen.demo.dto.Todo;
import com.chen.demo.dto.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{
    private final TodoRepository repository;

    @Autowired
    TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return repository.insert(todo);
    }

    @Override
    public Optional<Todo> deleteTodo(String id) {
        //Todo deletedTodo = repository.findOne(id);
        Optional<Todo> deletedTodo =  repository.findById(id);
        //repository.delete(id);
        repository.deleteById(id);
        return deletedTodo;
    }

    @Override
    public List<Todo> findAll(String username) {
        return repository.findByUserUsername(username);
    }

    @Override
    public Optional<Todo> findById(String id) {
        //return repository.findOne(id);
        return repository.findById(id);
    }

    @Override
    public Todo update(Todo todo) {
        repository.save(todo);
        return todo;
    }
}