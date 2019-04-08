package com.example.demo.test;

import java.io.UnsupportedEncodingException;

public class MD5AndDES {
	
	/**
	 * 给wei用MD5加密
	 * @param wei
	 * @return
	 */
	public String md5(String wei){
		String jia = "";
		EncryptionMD5 md5 = new EncryptionMD5();
		jia = md5.getMD5ofStr(wei);
		return jia;
	}
	
	/**
	 * 给wei用DES加密
	 * @param wei
	 * @return
	 */
	public String des(String wei){
		String jia = "";
		EncryptionDES des = new EncryptionDES();
		try {
			wei = java.net.URLEncoder.encode(wei,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jia = des.encrypt(wei);
		return jia;
	}
	
	/**
	 * 给jia用DES解密
	 * @param jia
	 * @return
	 */
	public String endes(String jia){
		String wei = "";
		EncryptionDES des = new EncryptionDES();
		wei = des.decrypt(jia);
		return wei;
	}

	/**
	 * 获取一位随机大写字母
	 * @return
	 */
	public String randomS(){
		String s = "";
		String[] rand = {"Q","E","W","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
		int ran = (int)Math.random()*26;
		s = rand[ran];
		return s;
	}

	/**
	 * MD5和DES混合
	 * 1.先把MD5+1空位字符，变为33位
	 * 2.把新MD5分为7份--1，1，2，3，5，8，13
	 * 3.分别插入DES的前7个质数位-1位后(1，2，4，6，10，12，16后)组成49位新密码
	 * @param wei
	 * @return
	 */
	public String MAndD(String MD5, String DES){
		String jia = "";
		String m = MD5+this.randomS();
		String m1 = m.substring(0, 1);
		String m2 = m.substring(1, 2);
		String m3 = m.substring(2, 4);
		String m4 = m.substring(4, 7);
		String m5 = m.substring(7, 13);
		String m6 = m.substring(13, 21);
		String m7 = m.substring(21);
		String d = DES;
		String d1 = d.substring(0, 2);
		String d2 = d.substring(2, 3);
		String d3 = d.substring(3, 5);
		String d4 = d.substring(5, 7);
		String d5 = d.substring(7, 11);
		String d6 = d.substring(11, 12);
		String d7 = "";
		String d8 = "";
		if(d.length()<=16){
			d7 = d.substring(12);
		}else{
			d7 = d.substring(12, 16);
			d8 = d.substring(16);
		}
		jia = d1+m1+d2+m2+d3+m3+d4+m4+d5+m5+d6+m6+d7+m7+d8;
		return jia;
	}
	
	/**
	 * 把混合的密码还原
	 * 1.删除MD5字符
	 * 2.DES解密
	 * @param jia
	 * @return
	 */
	public String Restore(String jia){
		if(jia==null||jia.equalsIgnoreCase(""))
		{
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
		if(jia.length()>49){
			m8 = m.substring(49);
		}
		wei = m1+m2+m3+m4+m5+m6+m7+m8;
		wei = this.endes(wei);
		try {
			wei = java.net.URLDecoder.decode(wei, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wei;
	}

	/**
	 * @param test
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		MD5AndDES mm = new MD5AndDES();
		String s1 = mm.md5("zz");
//		String input = "我是中文";
		String s2 = mm.des("计世在线网络技术");
		String s3 = mm.MAndD(s1, s2);
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(s3);
		System.out.println(mm.Restore(s3));
//		String s4 = mm.Restore(s3);
//		System.out.println("endes = "+s4);
//		System.out.println(mm.Restore("AD789270D3CDDAA5C4B8D242EA299E7D514085AEED9C0D3EQ614FA25AC585204B0DE7FA2639D08DAABE1A59C77A1EA53A"));
		//AD28527ED3C1BCA5C4B423B0EB7200F4814085FC5FF71C8EQ614FA25AC585204B0DE7FA2639D08DAABE1A59C77A1EA53A
	}

}
