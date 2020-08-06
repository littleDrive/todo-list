package com.thoughtworks.todo_list.service;

import com.thoughtworks.todo_list.model.Todo;
import com.thoughtworks.todo_list.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public List<Todo> getTodos() {

        return todoRepository.findAll();
    }

    public Todo insertTodo(Todo todo) {
        return  todoRepository.save(todo);
    }

    public Todo updatetTodo(Integer id, Todo todo) {

        Todo shouldUpdateTodo = todoRepository.findById(id).orElse(null);
        shouldUpdateTodo.setContent(todo.getContent());
        shouldUpdateTodo.setStatus(todo.getStatus());
        return todoRepository.save(shouldUpdateTodo);
    }
}
