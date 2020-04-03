package com.service.impl;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String name, String pwd) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        criteria.andEqualTo("pwd", pwd);
        return userDao.selectOneByExample(example);
    }

    @Override
    public List<User> findSex(String sex) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sex", sex);
        List<User> users = userDao.selectByExample(example);
        return users;
    }

    @Override
    public List<User> findAll() {
        return userDao.selectAll();
    }
}
