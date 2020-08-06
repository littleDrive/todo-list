package com.thoughtworks.todo_list.exception;

public class InvalidIdException extends RuntimeException {

    public static final String EXCEPTION_MASSAGE = "can not update todo, because can not find the same id in database ";
}
