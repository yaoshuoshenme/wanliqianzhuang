package com.qzwl.provider.user;

import com.qzwl.common.result.R;
import com.qzwl.common.util.EncrypUtil;
import com.qzwl.domain.User;
import com.qzwl.mapper.user.UserMapper;
import com.qzwl.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceProvider implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public R save(User user) {
        String newPass = EncrypUtil.md5Pass(user.getPassword());
        user.setPassword(newPass);
        if(mapper.insert(user) > 0){
            return R.setOK();
        }
        return R.setERROR();
    }
}
