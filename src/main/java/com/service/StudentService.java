package com.service;

import com.domain.Student;
import com.domain.Subject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StudentService {
    public PageInfo<Student> findAll(Integer page, Integer pageSize);

    public Student findName$Id(String name, Integer id);

    public boolean save(Student student);

    public List<Student> find();
}
