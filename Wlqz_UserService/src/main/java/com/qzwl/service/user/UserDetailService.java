package com.qzwl.service.user;

import com.qzwl.common.result.R;
import com.qzwl.domain.UserDetail;
import org.springframework.web.multipart.MultipartFile;

public interface UserDetailService {
    R insert(UserDetail record, MultipartFile[] multipartFile);


    R selectByUid(Integer uid);


    R updateByUid(Integer uid, Integer flag);
}
