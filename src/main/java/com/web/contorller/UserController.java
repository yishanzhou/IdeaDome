package com.web.contorller;

import com.domain.User;
import com.service.UserService;
import com.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("Login")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    @RequestMapping("login")
    public User login(String name, String pwd) {
        User login = userService.login(name, pwd);
        return login;
    }

    @RequestMapping("findSex")
    public List<User> findSex(String sex) {
        List<User> sex1 = userService.findSex(sex);
        return sex1;
    }

    @RequestMapping("findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
}
