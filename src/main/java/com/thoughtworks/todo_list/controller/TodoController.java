package com.thoughtworks.todo_list.controller;

import com.thoughtworks.todo_list.RequestTodo.RequestTodo;
import com.thoughtworks.todo_list.mapper.RequestMapper;
import com.thoughtworks.todo_list.model.Todo;
import com.thoughtworks.todo_list.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RequestTodo> getTodos() {

        return RequestMapper.changeTodosToRequestTodos(todoService.getTodos());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RequestTodo insertTodo(@RequestBody RequestTodo requestTodo) {

        Todo todo =  RequestMapper.changeRequestTodoToTodo(requestTodo);
        return RequestMapper.changeTodoToRequestTodo(todoService.insertTodo(todo));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RequestTodo updateTodo(@RequestBody RequestTodo requestTodo, @PathVariable Integer id) {

        Todo todo =  RequestMapper.changeRequestTodoToTodo(requestTodo);
        return RequestMapper.changeTodoToRequestTodo(todoService.updatetTodo(id,todo));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodo(@PathVariable Integer id) {
        todoService.deleteById(id);
    }



}
