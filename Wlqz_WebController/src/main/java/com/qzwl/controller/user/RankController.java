package com.qzwl.controller.user;

import com.qzwl.common.result.R;
import com.qzwl.domain.Rank;
import com.qzwl.service.user.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RankController {
    @Autowired
    private RankService service;

    @RequestMapping("/saverank.do")
    public R saverank(Rank rank, MultipartFile[] multipartFiles){
        return service.insert(rank,multipartFiles);
    }

    @RequestMapping("/queryrank.do")
    public R queryRank(Integer uid){
        return service.selectByUid(uid);
    }

    @RequestMapping("/reviewrank.do")
    public R reviewRank(Integer id, Integer flag){
        return service.updateByUid(id,flag);
    }
}
