package com.example.demo.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by zhang_xubin on 2019/4/3.
 *
 * @copyright It's not allowed to use this file content in any form include
 * reproduce and modify without the original author's permission
 */
public class MD5AndAES {

    /**
     * md5加密
     *
     * @param wei
     * @return
     */
    public String md5(String wei) {
        return new EncryptionMD5().getMD5ofStr(wei);
    }

    /**
     * aes 加密
     *
     * @param wei
     * @return
     */
    public String aes(String wei) {
        EncryptionAES aes = new EncryptionAES();
        try {
            wei = URLEncoder.encode(wei, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return aes.encrypt(wei);
    }

    public String MAndA(String MD5, String AES) {
        String jia = "";
        String m = MD5 + randomS();
        String m1 = m.substring(0, 1);
        String m2 = m.substring(1, 2);
        String m3 = m.substring(2, 4);
        String m4 = m.substring(4, 7);
        String m5 = m.substring(7, 13);
        String m6 = m.substring(13, 21);
        String m7 = m.substring(21);
        String d = AES;
        String d1 = d.substring(0, 2);
        String d2 = d.substring(2, 3);
        String d3 = d.substring(3, 5);
        String d4 = d.substring(5, 7);
        String d5 = d.substring(7, 11);
        String d6 = d.substring(11, 12);
        String d7 = "";
        String d8 = "";
        if (d.length() <= 16) {
            d7 = d.substring(12);
        } else {
            d7 = d.substring(12, 16);
            d8 = d.substring(16);
        }
        jia = d1 + m1 + d2 + m2 + d3 + m3 + d4 + m4 + d5 + m5 + d6 + m6 + d7 + m7 + d8;
        return jia;
    }


    /**
     * 把混合的密码还原
     * 1.删除MD5字符
     * 2.AES解密
     *
     * @param jia
     * @return
     */
    public String restore(String jia) {
        if (jia == null || jia.equalsIgnoreCase("")) {
            return "";
        }
        String wei = "";
        String m = jia;
        String m1 = m.substring(0, 2);
        String m2 = m.substring(3, 4);
        String m3 = m.substring(5, 7);
        String m4 = m.substring(9, 11);
        String m5 = m.substring(14, 18);
        String m6 = m.substring(24, 25);
        String m7 = m.substring(33, 37);
        String m8 = "";
        if (jia.length() > 49) {
            m8 = m.substring(49);
        }
        wei = m1 + m2 + m3 + m4 + m5 + m6 + m7 + m8;
        wei = EncryptionAES.decrypt(wei);
        try {
            wei = URLDecoder.decode(wei, "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wei;
    }

    /**
     * 获取一位随机大写字母
     * @return
     */
    private String randomS(){
        String[] rand = {"Q","E","W","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
        int ran = (int)Math.random()*26;
        return rand[ran];
    }

    public static void main(String ag[]){
        System.out.print("");
    }

}
