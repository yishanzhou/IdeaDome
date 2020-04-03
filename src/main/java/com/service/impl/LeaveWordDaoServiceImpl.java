package com.service.impl;

import com.dao.LeaveWordDao;
import com.domain.LeaveWord;
import com.dto.PageDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.LeaveWordDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveWordDaoServiceImpl implements LeaveWordDaoService {

    @Autowired
    private LeaveWordDao leaveWordDao;

    @Override
    public List<LeaveWord> findAll() {
        return leaveWordDao.selectAll();
    }

    @Override
    public PageInfo<LeaveWord> findAll(Integer page, PageDto pageDto) {
        if (page != null) {
            pageDto.setPage(page);
        }
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        List<LeaveWord> all = leaveWordDao.findAll();
        PageInfo<LeaveWord> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }
}
