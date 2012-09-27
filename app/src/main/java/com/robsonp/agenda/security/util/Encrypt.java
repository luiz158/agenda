package com.robsonp.agenda.security.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Encrypt {
    
    public static String md5(String content){
        return DigestUtils.md5Hex(content);
    }
    
    public static String sha256(String content){
        return DigestUtils.sha256Hex(content);
    }
}
