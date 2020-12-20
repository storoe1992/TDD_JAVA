package org.example.test.util;

public class StringUtil {

    public static boolean isEmpty(String str){
        return str == null  || str.trim().equals("");
    }
}
