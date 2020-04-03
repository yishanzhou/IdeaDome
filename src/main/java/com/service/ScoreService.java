package com.service;

import com.domain.Score;
import com.domain.Student;
import com.github.pagehelper.PageInfo;

public interface ScoreService {
    public boolean save(Score score);

    public PageInfo<Score> findAll(Integer page, Integer pageSize);
}
