package com.work.todolist.todolist.mapper;

import com.work.todolist.todolist.domain.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {
    @Select("SELECT * FROM todo")
    List<Todo> allTodo();
    @Select("SELECT * FROM todo WHERE date_time=#{dateTime}")
    List<Todo> todoList(String dateTime);
    @Insert("INSERT INTO todo (date_time, title, content, created_at) values (#{dateTime}, #{title}, #{content}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addTodo(Todo todo);
    @Update("UPDATE todo SET date_time=#{dateTime}, title=#{title}, content=#{content} WHERE id=#{id}")
    void updateTodo(Todo todo);
    @Delete("DELETE FROM todo WHERE id=#{id}")
    void deleteTodo(Long id);
}
