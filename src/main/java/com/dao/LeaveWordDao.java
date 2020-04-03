package com.dao;

import com.domain.LeaveWord;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LeaveWordDao extends Mapper<LeaveWord> {
    @Results({
            @Result(column = "name", property = "user.name")
    })
    @Select("select a.*,b.name from leaveWord a,users b where a.userid=b.id")
    public List<LeaveWord> findAll();
}
