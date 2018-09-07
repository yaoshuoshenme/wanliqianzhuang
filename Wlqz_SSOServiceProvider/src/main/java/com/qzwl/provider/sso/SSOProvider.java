package com.qzwl.provider.sso;

import com.alibaba.fastjson.JSON;
import com.qzwl.common.result.R;
import com.qzwl.common.util.EncrypUtil;
import com.qzwl.common.util.JedisUtil;
import com.qzwl.domain.User;
import com.qzwl.mapper.user.UserMapper;
import com.qzwl.service.sso.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


@Service
public class SSOProvider implements SSOService {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private JedisUtil jedisUtil;

    //登录
    @Override
    public R selectByName(String username, String password) {
        //查询数据库
        User user = mapper.selectByName(username);
        if(null != user){
            //校验密码
            String passwordMd5 = EncrypUtil.md5Pass(password);
            //相同登录成功
            if(Objects.equals(user.getPassword(),passwordMd5)){
                //生成token
                String token = EncrypUtil.md5Pass(user.getId().toString(),user.getUsername());
                //存redis
                jedisUtil.addStr(token,JSON.toJSONString(user));
                //返回token
                return new R(0,"ok",token);
            }
            return new R(1001,"密码不正确");
        }

        return new R(1002,"用户不存在");
    }

    //校验令牌
    @Override
    public R loginCheck(String token) {
        //判断redis是否存在
        if(jedisUtil.isKey(token)){
            //取值重新设置有效时间
            String json = jedisUtil.getStr(token);
            jedisUtil.expire(token,TimeUnit.MINUTES,30);
            return new R(0,"登陆成功",JSON.parseObject(json,User.class));
        }
        return new R(1,"未登录");
    }

    @Override
    public R logout(String token) {
        jedisUtil.delKey(token);
        return R.setOK();
    }


}
