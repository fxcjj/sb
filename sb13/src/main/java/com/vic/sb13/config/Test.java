package com.vic.sb13.config;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author 罗利华
 * date: 2019/8/7 10:46
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        URLDecoder decoder = new URLDecoder();
        String a = "https://prod.gxb.io/v2/auth/fundprocessing?channelCode=ACCUFUND_SHANGHAI&channelName=%E4%B8%8A%E6%B5%B7&returnUrl=http%3A%2F%2Fsandbox.sxfq.com%2Fhuolika-api-web%2Fv5%2Fcredit%2Fgxb%2FredirectAuthHtml%3FauthType%3D6%26relationId%3D34%26relationType%3D0%26authChannel%3D4%26appId%3D6%26query_id%3D0092901472000jI6UWgfh7vOtVujiFCG%26terminalType%3D0&token=0092901472000jI6UWgfh7vOtVujiFCG";
        String decode = URLDecoder.decode(a, "utf-8");
        System.out.println(decode);
    }
}
