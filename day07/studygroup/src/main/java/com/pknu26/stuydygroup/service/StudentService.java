package com.pknu26.stuydygroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.StudentMapper;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<student> getAllStudents() {
        return studentMapper.findAll();
    }
}
