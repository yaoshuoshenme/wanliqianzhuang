package com.qzwl.service.sso;

import com.qzwl.common.result.R;


public interface SSOService {

    R selectByName(String username, String password);
    R loginCheck(String token);
    R logout(String token);
}
