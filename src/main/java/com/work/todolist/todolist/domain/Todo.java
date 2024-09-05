package com.work.todolist.todolist.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Todo {
    private Long id; //todo id
    private String dateTime; //날짜 작성(시간X 날짜만)
    private String title; //todo 제목
    private String content; //todo 내용
    private LocalDateTime createdAt; //todo 작성 날짜
    private Integer priority; //우선 순위 설정
    private Boolean completed; //완료 상태
    private LocalDateTime dueDate; //기한
}
