package com.work.todolist.todolist.mapper;

import com.work.todolist.todolist.domain.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {
//    todo 전체 조회
    @Select("SELECT * FROM todo")
    List<Todo> allTodo();
//    todo 해당 날짜 조회
    @Select("SELECT * FROM todo WHERE date_time=#{dateTime}")
    List<Todo> todoList(String dateTime);
//    todo 작성
    @Insert("INSERT INTO todo (date_time, title, content, created_at, priority, completed, due_date) " +
            "VALUES (#{dateTime}, #{title}, #{content}, NOW(), #{priority}, #{completed}, #{dueDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addTodo(Todo todo);
//    todo 수정
    @Update("UPDATE todo SET date_time=#{dateTime}, title=#{title}, content=#{content}, " +
            "priority=#{priority}, completed=#{completed}, due_date=#{dueDate} WHERE id=#{id}")
    void updateTodo(Todo todo);
//   완료여부 수정
    @Update("UPDATE todo SET completed=#{completed} WHERE id=#{id}")
    void updateCompletionStatus(@Param("id") Long id, @Param("completed") Boolean completed);
//  todo 삭제
    @Delete("DELETE FROM todo WHERE id=#{id}")
    void deleteTodo(Long id);
}
