package com.example.demo.test;

/**
 * Created by zhang_xubin on 2019/4/3.
 *
 * @copyright It's not allowed to use this file content in any form include
 * reproduce and modify without the original author's permission
 */
public class DES2AES {
    public static void main(String aa[]){
        MD5AndDES md = new MD5AndDES();
        MD5AndAES ma = new MD5AndAES();
        String des = "0090693EA93B83EAEA1E12AD3B6EF6E22A1471C530C92873QA3A184D5096A842DA20A6FBF194E077AAE311149186429F11C4CF76726250F58B0E464ACB0B5226384079097F71C4FACAD324553ADAEB56FD3F76DD9AAFBC9E7BD3B5E5659BA3C6918CF6881EA537D607A857982E4D3E3CB3631B31B73586DD9";
        System.out.println(des);
        String res = md.Restore(des);
        System.out.println(res);
        String aes = ma.MAndA(ma.md5(res),ma.aes(res));
        System.out.println(aes);
        System.out.println(ma.restore(aes));


    }
}
