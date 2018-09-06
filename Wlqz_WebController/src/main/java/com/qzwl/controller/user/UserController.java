package com.qzwl.controller.user;

import com.qzwl.common.result.R;
import com.qzwl.domain.User;
import com.qzwl.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/usersave.do")
    public R save(User user){
        return service.save(user);
    }

}
