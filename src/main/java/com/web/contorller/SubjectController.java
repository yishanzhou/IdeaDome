package com.web.contorller;

import com.domain.LeaveWord;
import com.domain.Subject;
import com.dto.PageDto;
import com.github.pagehelper.PageInfo;
import com.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("findAll")
    public PageInfo<Subject> findAll(Integer page, Integer pageSize) {
        PageInfo<Subject> all = subjectService.findAll(page, pageSize);
        return all;
    }

    ;
}
