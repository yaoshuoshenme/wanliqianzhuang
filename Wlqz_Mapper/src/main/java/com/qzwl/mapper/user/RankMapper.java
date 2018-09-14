package com.qzwl.mapper.user;


import com.qzwl.domain.Rank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RankMapper {

    int insert(Rank record);


    List<Rank> selectByUid(Integer uid);


    int updateByUid(@Param("id") Integer id, @Param("flag") Integer flag);
}