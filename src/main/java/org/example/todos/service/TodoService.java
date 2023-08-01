package org.example.todos.service;

import org.example.todos.error.NotFoundException;
import org.example.todos.model.Todo;
import org.example.todos.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepo;

    public Todo saveTodo(Todo todo) {
        return todoRepo.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    public Todo getById(int id) {
        try {
            return todoRepo.findById(id).get();

        }catch (NoSuchElementException e){
            throw new NotFoundException(String.format("No record with id [%s]",id));
        }
    }

    public void deleteTodo(int id) {
        todoRepo.deleteById(id);
    }
}


