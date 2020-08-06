package com.thoughtworks.todo_list.serviceTest;

import com.thoughtworks.todo_list.exception.InvalidIdException;
import com.thoughtworks.todo_list.model.Todo;
import com.thoughtworks.todo_list.repository.TodoRepository;
import com.thoughtworks.todo_list.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TodoServiceTest {


    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void should_return_todos_when_get_todos_given_nothing() {
        //given
        when(todoRepository.findAll()).thenReturn(asList(new Todo(1, "text1", true), new Todo(2, "text2", false)));

        //when
        List<Todo> todos = todoService.getTodos();

        //then
        assertEquals(2, todos.size());
    }

    @Test
    void should_return_todo_when_insert_todo_given_todo() {
        //given
        Todo todo = new Todo(1, "test", true);
        when(todoRepository.save(todo)).thenReturn(todo);

        //when
        Todo savedTodo = todoService.insertTodo(todo);

        //then
        assertNotNull(savedTodo);
        assertEquals(1, savedTodo.getId());
    }

    @Test
    void should_return_todo_when_update_todo_given_todo_and_id() {


        //given
        Integer id = 1;
        Todo todo = new Todo(1, "oocl", false);
        Todo shouldUpdatedtodo = new Todo(1, "test", true);
        when(todoRepository.findById(id)).thenReturn(Optional.of(shouldUpdatedtodo));
        when(todoRepository.save(shouldUpdatedtodo)).thenReturn(todo);

        //when

        Todo hasupdatedTodo = todoService.updatetTodo(id, todo);

        //then
        assertNotNull(hasupdatedTodo);
        assertEquals(1, hasupdatedTodo.getId());
        assertEquals("oocl", hasupdatedTodo.getContent());
        assertEquals(false, hasupdatedTodo.getStatus());
    }

    @Test
    void should_throws_invalid_id_exception_when_update_todo_given_invalid_id() {
        //given
        Integer id = 2;
        Todo todo = new Todo(1, "oocl", false);
        Todo shouldUpdatedtodo = new Todo(1, "test", true);
        when(todoRepository.findById(id)).thenReturn(Optional.of(shouldUpdatedtodo));
        when(todoRepository.save(shouldUpdatedtodo)).thenReturn(todo);

        //when
        assertThrows(NullPointerException.class, () -> todoService.updatetTodo(id, todo));


        //then
    }


}
