package com.thoughtworks.todo_list.RequestTodo;

import org.springframework.stereotype.Component;

@Component
public class RequestTodo {

    private Integer id;
    private String text;
    private Boolean status;

    public RequestTodo() {
    }

    public RequestTodo(Integer id, String text, Boolean status) {
        this.id = id;
        this.text = text;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
