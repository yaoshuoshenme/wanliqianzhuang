package com.qzwl.controller.user;

import com.qzwl.common.result.R;
import com.qzwl.domain.UserDetail;
import com.qzwl.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserDetailController {
    @Autowired
    private UserDetailService service;

    //新增
    @RequestMapping("/saveuserdetail.do")
    public R saveuserdetail(UserDetail userDetail, MultipartFile[] multipartFile){
        return service.insert(userDetail, multipartFile);
    }
    //查询
    @RequestMapping("queryuserdetail.do")
    public R queryuserdetail(Integer uid){
        return service.selectByUid(uid);
    }
    //审核,修改
    @RequestMapping("/review.do")
    public R review(Integer uid, Integer flag){
        return service.updateByUid(uid,flag);
    }
}
