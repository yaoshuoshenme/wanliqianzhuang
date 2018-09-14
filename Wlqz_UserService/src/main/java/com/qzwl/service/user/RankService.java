package com.qzwl.service.user;

import com.qzwl.common.result.R;
import com.qzwl.domain.Rank;
import org.springframework.web.multipart.MultipartFile;


public interface RankService {
    R insert(Rank record, MultipartFile[] multipartFiles);


    R selectByUid(Integer uid);


    R updateByUid(Integer id, Integer flag);
}
