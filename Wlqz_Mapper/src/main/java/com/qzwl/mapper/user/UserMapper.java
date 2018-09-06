package com.qzwl.mapper.user;


import com.qzwl.domain.User;

public interface UserMapper {

    int insert(User record);

    User selectByUid(Integer id);

    User  selectByName(String username);


    int updateByUid(Integer uid,Integer flag);
}