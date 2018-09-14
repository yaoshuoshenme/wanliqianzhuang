package com.qzwl.provider.user;

import com.qzwl.common.result.R;
import com.qzwl.common.util.FDFSUtil;
import com.qzwl.domain.UserDetail;
import com.qzwl.mapper.user.UserDetailMapper;
import com.qzwl.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceProvider implements UserDetailService {
    @Autowired
    private UserDetailMapper mapper;
    @Autowired
    private FDFSUtil fdfsUtil;

    @Override
    public R insert(UserDetail userDetail, MultipartFile[] multipartFile)  {
        List<String> filenames = new ArrayList<>();
        List<String> subs = new ArrayList<>();
        for(MultipartFile m : multipartFile){
            String filename = m.getOriginalFilename();
            filenames.add(filename);
            subs.add(m.getOriginalFilename().substring(filename.lastIndexOf(".") + 1));
        }

        List filepath = null;
        try {
            for(int i = 0; i < subs.size(); i++){
                filepath.add(fdfsUtil.upload_file(multipartFile[i].getBytes(), subs.get(i), null)[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(filepath.size() == 3){
            userDetail.setImage1((String)filepath.get(0));
            userDetail.setImage2((String)filepath.get(1));
            userDetail.setImage2((String)filepath.get(2));
            if(mapper.insert(userDetail) > 0){
                return R.setOK();
            }
        }
        return R.setERROR();
    }

    @Override
    public R selectByUid(Integer uid) {
        UserDetail userDetail = mapper.selectByUid(uid);
        if(null != userDetail){
            return new R(0,"ok",userDetail);
        }
        return R.setERROR();
    }

    @Override
    public R updateByUid(Integer uid, Integer flag) {
        return mapper.updateByUid(uid,flag) > 0 ? R.setOK():R.setERROR();
    }
}
