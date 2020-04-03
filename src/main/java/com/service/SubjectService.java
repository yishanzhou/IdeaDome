package com.service;

import com.domain.LeaveWord;
import com.domain.Subject;
import com.dto.PageDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SubjectService {
    public PageInfo<Subject> findAll(Integer page, Integer pageSize);
}
