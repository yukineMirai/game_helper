package com.dkm.game.data.utils;

public class StringUtils {


    /**
     * 判断value是否为空
     * @param value 传入的值
     * @return true 为空
     */
    public static boolean isEmpty(String value){

        if(value == null || value == " "){
            return true;
        }

        return false;
    }
}
