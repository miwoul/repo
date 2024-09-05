package com.work.todolist.todolist.controller;

import com.work.todolist.todolist.domain.Todo;
import com.work.todolist.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/create/todo")
    public void createTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    @GetMapping("/all/todo")
    public List<Todo> getAllTodos() {
        return todoService.allTodo();
    }

    @GetMapping("/todo/{datetime}")
    public List<Todo> getTodoByDatetime(@PathVariable String datetime) {
        return todoService.getTodo(datetime);
    }

    @PutMapping("/update/todo/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        todo.setId(id);
        todoService.updateTodo(todo);
        return todo;
    }

    @DeleteMapping("/delete/todo/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
