package com.service.impl;

import com.dao.ScoreDao;
import com.domain.Score;
import com.domain.Student;
import com.dto.PageDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Override
    public boolean save(Score score) {
        return scoreDao.insert(score) > 0 ? true : false;
    }

    @Override
    public PageInfo<Score> findAll(Integer page, Integer pageSize) {
        PageDto pageDto = new PageDto();
        if (page != null) {
            pageDto.setPage(page);
        }
        if (pageSize != null) {
            pageDto.setPageSize(pageSize);
        }
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        List<Score> all = scoreDao.find();
        PageInfo<Score> pageInfo = new PageInfo<>(all);
        return pageInfo;
    }
}
