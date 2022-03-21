package com.demo.test.util;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Administrator on 2021/9/6.
 */

public class CharSeqUtil {
    public static boolean isNullOrEmpty(CharSequence str){
        if(str==null||isEmpty(str)){
            return true;
        }else {
            return false;
        }
    }
}
