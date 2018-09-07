package com.qzwl.controller.user;

import com.qzwl.common.result.R;
import com.qzwl.domain.User;
import com.qzwl.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
    @Autowired
    private UserService service;

    //注册
    @PostMapping("/usersave.do")
    public R save(User user){
        return service.save(user);
    }



}
