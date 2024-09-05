package com.work.todolist.todolist.service;

import com.work.todolist.todolist.domain.Todo;
import com.work.todolist.todolist.mapper.SearchMapper;
import com.work.todolist.todolist.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoMapper todoMapper;
    @Autowired
    SearchMapper searchMapper;

//    todo 작성
    public void addTodo(Todo todo) {
        todoMapper.addTodo(todo);
    }
//  todo 조회
    public List<Todo> allTodo() {
        return todoMapper.allTodo();
    }
//  해당날짜 조회
    public List<Todo> getTodo(String todo) {
        return todoMapper.todoList(todo);
    }
//  todo 제목, 내용 조회
    public List<Todo> searchTodo(String query) {
        return searchMapper.search(query);
    }
//  todo 수정
    public void updateTodo(Todo todo) {
        todoMapper.updateTodo(todo);
    }
// todo 완료여부 수정
    public void updateCompletionStatus(Long id, Boolean completed) {
        todoMapper.updateCompletionStatus(id, completed);
    }
//  todo 삭제
    public void deleteTodo(Long id) {
        todoMapper.deleteTodo(id);
    }
}
