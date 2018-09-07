package com.qzwl.common.util;


import com.qzwl.common.result.R;

import java.io.Serializable;


public class ResultUtil implements Serializable {
    public static R createResult(int res){
        if(res>0){
            return R.setOK();
        }else {
            return R.setERROR();
        }
    }
}
