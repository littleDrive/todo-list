package com.thoughtworks.todo_list.handler;

import com.thoughtworks.todo_list.exception.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHanlder {

    @ExceptionHandler(InvalidIdException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String todoNotFound() {
        return "can not update todo, because can not find the same id in database ";
    }

}
