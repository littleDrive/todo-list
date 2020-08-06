package com.thoughtworks.todo_list.controller;

import com.thoughtworks.todo_list.model.Todo;
import com.thoughtworks.todo_list.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodos() {

        return todoService.getTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo insertTodo(@RequestBody Todo todo) {

        return todoService.insertTodo(todo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo updateTodo(@RequestBody Todo todo, @PathVariable Integer id) {

        return todoService.updatetTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodo(@PathVariable Integer id) {
        todoService.deleteById(id);
    }



}
