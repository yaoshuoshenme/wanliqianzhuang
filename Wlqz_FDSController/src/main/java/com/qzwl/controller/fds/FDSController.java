package com.qzwl.controller.fds;

import com.qzwl.common.result.R;
import com.qzwl.common.util.FDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RestController
public class FDSController {
    @Autowired
    private FDFSUtil fdfsUtil;

    public String url = "10.8.163.136";
    //上传
    @RequestMapping("/fileupload.do")
    public R fileupload(CommonsMultipartFile multipartFile){
        String filename = multipartFile.getOriginalFilename();
        String sub = filename.substring(filename.lastIndexOf("."));
        try {
            String[] filepath = fdfsUtil.upload_file(multipartFile.getBytes(),sub,null);
            return new R(0,"ok",filepath[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return R.setERROR();
        }

    }

}
