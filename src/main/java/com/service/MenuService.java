package com.service;

import com.domain.Menu;

import java.util.List;


public interface MenuService {
    public List<Menu> findMenusByPid(Integer pid);
}
