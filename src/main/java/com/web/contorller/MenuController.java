package com.web.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Menu;
import com.service.MenuService;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("find")
    public List<Menu> find(Integer pid) {
        return this.menuService.findMenusByPid(pid);
    }

}
