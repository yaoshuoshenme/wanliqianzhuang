package com.qzwl.provider.user;

import com.qzwl.common.result.R;
import com.qzwl.common.util.FDFSUtil;
import com.qzwl.domain.Rank;
import com.qzwl.mapper.user.RankMapper;
import com.qzwl.service.user.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankServiceProvider implements RankService {
    @Autowired
    private RankMapper mapper;
    @Autowired
    private FDFSUtil fdfsUtil;

    //新增
    @Override
    public R insert(Rank rank, MultipartFile[] multipartFile) {
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
        if(filepath.size() > 0){
            rank.setRankimages((String)filepath.get(0));

            if(mapper.insert(rank) > 0){
                return R.setOK();
            }
        }
        return R.setERROR();

    }

    //查询
    @Override
    public R selectByUid(Integer uid) {
        List<Rank> ranks = mapper.selectByUid(uid);
        if(null != ranks && ranks.size() > 0){
            return new R(0,"ok",ranks);
        }
        return  R.setERROR();
    }

    //修改
    @Override
    public R updateByUid(Integer id, Integer flag) {
        return mapper.updateByUid(id,flag) > 0 ? R.setOK():R.setERROR();
    }
}
