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

//    todo 생성
    @PostMapping("/create/todo")
    public void createTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

//    todo 전체조회
    @GetMapping("/all/todo")
    public List<Todo> getAllTodos() {
        return todoService.allTodo();
    }

//    날짜별 todo 조회 (dateTime에 입력한 날짜만 조회가능)
    @GetMapping("/todo/{datetime}")
    public List<Todo> getTodoByDatetime(@PathVariable String datetime) {
        return todoService.getTodo(datetime); // datetime은 String으로 처리됩니다.
    }

//    todo검색
    @GetMapping("/todo/search")
    public List<Todo> getTodoBySearch(@RequestParam String query) {
        return todoService.searchTodo(query);
    }

//    todo수정
    @PutMapping("/update/todo/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        todo.setId(id);
        todoService.updateTodo(todo);
        return todo;
    }
//    todo 완료변경
    @PutMapping("/update/todo/{id}/status")
    public void updateCompletionStatus(@PathVariable Long id, @RequestParam Boolean completed) {
        todoService.updateCompletionStatus(id, completed);
    }

//    todo삭제
    @DeleteMapping("/delete/todo/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
