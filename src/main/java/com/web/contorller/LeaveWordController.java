package com.web.contorller;

import com.domain.LeaveWord;
import com.dto.PageDto;
import com.github.pagehelper.PageInfo;
import com.service.LeaveWordDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Leave")
public class LeaveWordController {

    @Autowired
    private LeaveWordDaoService leaveWordDaoService;

    @RequestMapping("find")
    public List<LeaveWord> findAll() {
        return leaveWordDaoService.findAll();
    }

    ;

    @RequestMapping("findPage")
    public PageInfo<LeaveWord> findAll(Integer page, PageDto pageDto) {
        PageInfo<LeaveWord> all = leaveWordDaoService.findAll(page, pageDto);
        return all;
    }

    ;
}
