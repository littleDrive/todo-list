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
}
