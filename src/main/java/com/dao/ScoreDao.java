package com.dao;

import com.domain.Score;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ScoreDao extends Mapper<Score> {

    @Results(
            {
                    @Result(column = "uids", property = "student.id"),
                    @Result(column = "name", property = "student.name"),
                    @Result(column = "subname", property = "subject.subname"),
                    @Result(column = "img", property = "subject.img")
            }
    )
    @Select("select a.*,b.id as uids,b.name,c.subname,c.img from score a,student b,subject c where a.uid=b.id and a.sid=c.id")
    public List<Score> find();
}
