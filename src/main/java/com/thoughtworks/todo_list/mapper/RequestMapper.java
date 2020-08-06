package com.thoughtworks.todo_list.mapper;

import com.thoughtworks.todo_list.RequestTodo.RequestTodo;
import com.thoughtworks.todo_list.model.Todo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestMapper {

    public static RequestTodo changeTodoToRequestTodo(Todo todo) {
        return new RequestTodo(todo.getId(), todo.getContent(), todo.getStatus());
    }

    public static Todo changeRequestTodoToTodo(RequestTodo requestTodo) {
        return new Todo(requestTodo.getId(), requestTodo.getText(), requestTodo.getStatus());
    }

    public static List<RequestTodo> changeTodosToRequestTodos(List<Todo> todos) {
      return todos.stream().map(RequestMapper::changeTodoToRequestTodo).collect(Collectors.toList());
    }
}
