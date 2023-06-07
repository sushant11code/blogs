package com.project.social.blog.util;

import org.springframework.util.StringUtils;

import java.util.Collection;

public class NullOrEmptyUtil {
    public static boolean isNullOrEmpty(String str){
        return StringUtils.isEmpty(str);
    }
    public static boolean isNullOrEmpty(Object obj){
        return obj == null;
    }
}
