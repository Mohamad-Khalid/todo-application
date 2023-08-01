package com.example.todos;

import org.example.todos.service.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;
@Component
@RunWith(SpringRunner.class)
public class TodoServiceTest {
    @Autowired
    private TodoService todoService;

    @Test
    public void whenFindAllReturnTodoList(){

    }
}
