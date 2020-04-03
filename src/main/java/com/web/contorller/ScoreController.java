package com.web.contorller;

import com.domain.Score;
import com.domain.Student;
import com.github.pagehelper.PageInfo;
import com.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping("findAll")
    public PageInfo<Score> findAll(Integer page, Integer pageSize) {
        PageInfo<Score> all = scoreService.findAll(page, pageSize);
        return all;
    }

    ;

    @RequestMapping("save")
    public String findAll(Score score) {
        boolean save = scoreService.save(score);
        if (save) {
            return "插入成功";
        }
        return "插入失败";
    }

    ;
}
