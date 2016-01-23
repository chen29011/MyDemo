package com.cqlj.cataTools.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 字符串 DESede(3DES) 加密 设Ek()和Dk()代表DES算法的加密和解密过程， K代表DES算法使用的密 钥， P代表明文， C代表密表，
 * 3DES加密过程为： C=Ek3(Dk2(Ek1(P))) 3DES解密过程为： P=Dk1((EK2(Dk3(C)))
 * 对称密钥加密又叫专用密钥加密，即发送和接收数据的双 方必使用相同的密钥对明文进行加密和解密运算。 对称密钥加密算法主要包括： DES、 3DES、
 * IDEA、 FEAL、 BLOWFISH等。
 */
public class Utils3DES {
	private static final String Algorithm = "DESede";// 定义加密算法,可用DES,DESede,Blowfish
	// keyBytes为加密密钥，长度为24字节
	private static final byte[] keyBytes = { 0x31, 0x22, 0x4F, 0x58,
			(byte) 0x83, 0x10, 0x21, 0x38, 0x21, 0x25, 0x79, 0x51, (byte) 0xCB,
			(byte) 0xDD, 0x55, 0x66, 0x77, 0x29, 0x74, (byte) 0x98, 0x21, 0x54,
			0x36, (byte) 0xE2 };

	// src为被加密的数据缓冲区（源）
	public static byte[] encryptMode(byte[] src) {
		try {
			SecretKey deskey = new SecretKeySpec(keyBytes, Algorithm);// 生成密钥
			Cipher c1 = Cipher.getInstance(Algorithm);// 加密
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);// 在单一方面的加密或解密
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	// src为加密后的缓冲区
	public static byte[] decryptMode(byte[] src) {
		try {
			SecretKey deskey = new SecretKeySpec(keyBytes, Algorithm);// 生成密钥
			Cipher c1 = Cipher.getInstance(Algorithm);// 解密
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密String明文输入,String密文输出
	 * 
	 * @param strMing
	 * @return
	 */
	public static String encryptString(String strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = strMing.getBytes("UTF8");
			byteMi = encryptMode(byteMing);
			strMi = base64en.encode(byteMi);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			base64en = null;
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public static String decryptString(String strMi) {
		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = base64De.decodeBuffer(strMi);
			byteMing = decryptMode(byteMi);
			strMing = new String(byteMing, "UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			base64De = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}
}