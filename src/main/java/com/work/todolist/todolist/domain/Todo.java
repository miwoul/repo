package com.work.todolist.todolist.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Todo {
    private Long id;
    private String dateTime;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
