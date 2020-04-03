package com.service.impl;

import com.dao.StudentDao;
import com.domain.Student;
import com.domain.Subject;
import com.dto.PageDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public PageInfo<Student> findAll(Integer page, Integer pageSize) {
        PageDto pageDto = new PageDto();
        if (page != null) {
            pageDto.setPage(page);
        }
        if (pageSize != null) {
            pageDto.setPageSize(pageSize);
        }
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        List<Student> all = studentDao.selectAll();
        PageInfo<Student> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }

    @Override
    public Student findName$Id(String name, Integer id) {
        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        if (name != null && !"".equals(name)) {
            criteria.andEqualTo("name", name);
        }
        if (id != null && !"".equals(id)) {
            criteria.andEqualTo("id", id);
        }
        Student student = new Student();
        if ("".equals(name) && id == null) {
            return student;
        }
        student = studentDao.selectOneByExample(example);
        return student;
    }

    @Override
    public boolean save(Student student) {
        student.setTime(new Date());
        return studentDao.insert(student) > 0 ? true : false;
    }

    @Override
    public List<Student> find() {
        return studentDao.selectAll();
    }
}
