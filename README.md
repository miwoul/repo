## todo api
# 1. 자신이 개발한 앱에 대한 설명
제가만든 것은 Todo api 입니다.
가장 기본적인 CRUD 생성, 조회, 수정, 삭제를 할 수 있으며, 완료여부만 수정 할 수도 있고, 제목이랑 내용으로 작성 한 글을 검색할 수도 있습니다.
<hr />
# 2. 소스 빌드 및 실행 방법 메뉴얼 (DB 스키마 포함)
gradle로 했으며, 
실행을 하기위해서는 우선,
git clone https://github.com/miwoul/repo.git 클론을 하여 todolistApplication을 실행시키면 실행시킬 수 있습니다.
실행시키기 전에 db랑 연동이 안될 경우
spring.datasource.url=jdbc:mysql://{DB주소:DB포트번호}/{DB이름}
spring.datasource.username={사용자}
spring.datasource.password={비밀번호}
를 자신의 것으로 수정하면 됩니다.
DB table은
create table todo (
id bigint auto_increment primary key,
date_time varchar(255),
title text,
content text,
created_at TIMESTAMP DEFAULT current_timestamp,
priority INT DEFAULT 0,
completed BOOLEAN DEFAULT FALSE,
due_date DATETIME
);
이렇게 작성하면 정상동작 할 수 있습니다.
<hr />
# 3. 주력으로 사용한 컴포넌트에대한 설명 및 사용 이유 기입
Spring Boot:
Spring Boot를 사용하여 '@'을 사용하여 쉽고 빠르게 애플리케이션을 개발할 수 있으며, 내장된 서버와 자동 설정이 있어 이를 통해 배포가 용이하여 사용하였습니다.
MyBatis:
MyBatis는 SQL Mapper 프레임워크로, 데이터베이스 쿼리를 쉽게 작성하고 매핑할 수 있으며, '@'을 이용 한 Mapping 파일을 통해 SQL 쿼리와 java 객체 간의 Mapping을 할 수 있어 사용하였습니다.
Lombok:
Lombok은 자바 객체에 대해 getter, setter, 생성자 등을 자동으로 생성해주는 라이브러리로, 코드의 간결성을 유지할 수 있어 사용했습니다.
MySQL:
MySQL은 널리 사용되는 오픈 소스 데이터베이스로, 높은 성능과 안정성을 제공하여 사용하였습니다.
domain을 만들어 @Getter와 @Setter을 이용하여 객체를 가져왔으며,
mapper을 사용하여 SQL쿼리와 java 객체 간의 mapping을 하고,
service를 만들어 mapper를 가져와 사용할 수있게 한 후,
controller을 만들어 실제로 url을 사용하여 실 사용을 할 수있게 만들었습니다.
<hr />
# 4. Api 명세 작성 필수 → Swagger 등 사용해도 무방함
 1. todo작성

- **URL:** `POST /api/create/todo`
- **Request Body:**
    
    ```json
    {
      "dateTime": "2024-09-05",
      "title": "New Task",
      "content": "This is a new task",
      "priority": 3,
      "completed": false,
      "dueDate": "2024-09-10T23:59:59"
    }
    ```
    

 2. todo전체조회

- **URL:** `GET /api/all/todon`
- **Response:**
    
    ```json
    {
            "id": 1,
            "dateTime": "2024-09-05",
            "title": "New Task",
            "content": "This is a new task",
            "createdAt": "2024-09-05T19:33:26",
            "priority": 3,
            "completed": false,
            "dueDate": "2024-09-10T23:59:59"
        },
    ```
    

 3. todo 해당 날짜 할일 조회

- **URL:** `GET /api/todo/{datetime}`
- **Request Header:**
    
    ```makefile
    http://localhost:8080/api/todo/2024-09-05
    ```
    
- **Response:**
    
    ```json
    {
            "id": 1,
            "dateTime": "2024-09-05",
            "title": "New Task",
            "content": "This is a new task",
            "createdAt": "2024-09-05T19:33:26",
            "priority": 3,
            "completed": false,
            "dueDate": "2024-09-10T23:59:59"
        },
    ```
    

 4. todo검색

- **URL:** `GET /api/todo/search?query=new`
- **Response:**
    
    ```json
    {
            "id": 1,
            "dateTime": "2024-09-05",
            "title": "New Task",
            "content": "This is a new task",
            "createdAt": "2024-09-05T19:33:26",
            "priority": 3,
            "completed": false,
            "dueDate": "2024-09-10T23:59:59"
        },
    ```
    

 5. todo수정

- **URL:** `PUT /api/update/todo/{id}`
- **Request Body:**
    
    ```makefile
    {
      "dateTime": "2024-09-05",
      "title": "Updated Todo",
      "content": "Updated",
      "priority": 4,
      "completed": true,
      "dueDate": "2024-09-12T23:59:59"
    }
    ```
    

 6. todo완료 상태 수정

- **URL:** `PUT /api/update/todo/{id}/status`
- **Request Header:**
    
    ```json
    http://localhost:8080/api/update/todo/1/status?completed=false
    ```
    

 7. todo삭제

- **URL:** `DELETE /api/delete/todo/{id}`6. 기본 CRUD 업무 이외에 추가적인 업무 Api 필수 (Ex -> 일정 공유 기능)
