package com.work.todolist.todolist.service;

import com.work.todolist.todolist.domain.Todo;
import com.work.todolist.todolist.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoMapper todoMapper;
    public List<Todo> allTodo() {
        return todoMapper.allTodo();
    }

    public List<Todo> getTodo(String todo) {
        return todoMapper.todoList(todo);
    }

    public void addTodo(Todo todo) {
        todoMapper.addTodo(todo);
    }

    public void updateTodo(Todo todo) {
        todoMapper.updateTodo(todo);
    }

    public void deleteTodo(Long id) {
        todoMapper.deleteTodo(id);
    }
}
