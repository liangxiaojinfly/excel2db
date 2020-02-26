/*
 * Copyright (c) 2016, hejinonline and/or its affiliates. All rights reserved.
 * THE CONTENTS OF THIS FILE MAY NOT BE DISCLOSED,
 * TO THIRD PARTIES, COPIED OR DUPLICATED IN ANY FORM, IN WHOLE OR IN PART,
 * WITHOUT THE PRIOR WRITTEN PERMISSION .
 */
package cn.cpic.dmgr.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class Des {
	

	public Des() {
	}
	public static String strKey = "89337899";
	// 加密
	public static String Encrypt(String str) {
		// 密钥
		byte[] encrypt = null;
		try {
			SecretKeySpec key = new SecretKeySpec(strKey.getBytes(), "DES");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypt = cipher.doFinal(str.getBytes());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return byte2Hex(encrypt);
	}

	// 解密
	public static String Decrypt(String strFinal) {
		byte[] decrypt = null;
		try {
			SecretKeySpec key = new SecretKeySpec(strKey.getBytes(), "DES");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decByte = hex2Byte(strFinal);
			decrypt = cipher.doFinal(decByte);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return new String(decrypt);
	}

	public static void main(String[] args) throws Exception {
		
	}

	public static String byte2Hex(byte[] buff) {
		String hs = "";
		for (int i = 0; i < buff.length; i++) {
			String stmp = (Integer.toHexString(buff[i] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs;
	}

	public static byte[] hex2Byte(String str) {
		int len = str.length() / 2;
		byte[] buff = new byte[len];
		int index = 0;
		for (int i = 0; i < str.length(); i += 2) {
			buff[index++] = (byte) Integer.parseInt(str.substring(i, i + 2), 16);
		}
		return buff;
	}
}
