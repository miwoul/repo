package com.work.todolist.todolist.mapper;

import com.work.todolist.todolist.domain.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchMapper {
    @Select("SELECT * FROM todo WHERE " +
            "title LIKE CONCAT('%', #{query}, '%') OR " +
            "content LIKE CONCAT('%', #{query}, '%')")
    List<Todo> search(String query);
}
