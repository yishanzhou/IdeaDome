package com.service;

import com.domain.LeaveWord;
import com.dto.PageDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LeaveWordDaoService {
    public List<LeaveWord> findAll();

    public PageInfo<LeaveWord> findAll(Integer page, PageDto pageDto);
}
