package com.pknu26.restapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pknu26.restapi.entity.Student;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*; // *은 이런 이름의 뒤에꺼 전부 사용하겠다는 뜻.




@RestController
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()); // StudentController에 속하는 로거가 됨    // Logger logger 다르다.

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API!";
    }
    
    @GetMapping("/student")
    public Student getStudent() {
        return new Student("유고", 49);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
   
        return List.of(
            new Student("유고", 49),
            new Student("애슐리", 42),
            new Student("홍길동", 19)
        );
    }
    
    @GetMapping("/hello2")
    public String hello2(@RequestParam String name) {
        return "Hello" + name;
    }
    
    @GetMapping("/user/{id}")
    public String getuser(@PathVariable int id) {
        return "User ID: " + id;
    }

    @PostMapping("/student")
    public Student createuser(@RequestBody Student student) {
        logger.info(student.getName());
        logger.info(String.valueOf(student.getAge()));
        
        return student;
    }
    
}
