package com.service.impl;

import com.dao.SubjectDao;
import com.domain.LeaveWord;
import com.domain.Subject;
import com.dto.PageDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public PageInfo<Subject> findAll(Integer page, Integer pageSize) {
        PageDto pageDto = new PageDto();
        if (page != null) {
            pageDto.setPage(page);
        }
        if (pageSize != null) {
            pageDto.setPageSize(pageSize);
        }
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        List<Subject> all = subjectDao.selectAll();
        PageInfo<Subject> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }
}
