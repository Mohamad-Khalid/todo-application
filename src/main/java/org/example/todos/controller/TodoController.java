package org.example.todos.controller;

import org.example.todos.model.Todo;
import org.example.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/allTodos")
   public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> result = todoService.getAllTodos();
        return new ResponseEntity<List<Todo>>(result,HttpStatus.OK);
    }
    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getById(@PathVariable int id){
        Todo result = todoService.getById(id);
        return new ResponseEntity<Todo>(result,HttpStatus.OK);
    }

    @PostMapping("/addTodo")
    public ResponseEntity<Todo> add(@Validated @RequestBody Todo todo){
        Todo result = todoService.saveTodo(todo);
        return new ResponseEntity<Todo>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
