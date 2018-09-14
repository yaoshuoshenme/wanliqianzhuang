package com.qzwl.mapper.user;


import com.qzwl.domain.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailMapper {

    int insert(UserDetail record);


    UserDetail selectByUid(Integer uid);


    int updateByUid(@Param("uid") Integer uid, @Param("flag") Integer flag);
}