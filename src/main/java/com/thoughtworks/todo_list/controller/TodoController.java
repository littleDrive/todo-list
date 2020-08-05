package com.thoughtworks.todo_list.controller;

import com.thoughtworks.todo_list.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodos() {

        return new ArrayList<>(asList(new Todo(1, "text1", true), new Todo(2, "text2", false)));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo insertTodo(@RequestBody Todo todo) {

        return todo;
    }


}
