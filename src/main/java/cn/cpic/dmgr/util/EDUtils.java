package cn.cpic.dmgr.util;

import com.cpic.caf.compon.tech.utils.DESUtil;
import com.cpic.caf.compon.tech.utils.HexUtil;
import org.apache.log4j.Logger;

import java.nio.charset.Charset;


public class EDUtils {

	private static Logger log = Logger.getLogger(EDUtils.class);

	private static final String ENCODE = "UTF-8";

	private static final String KEY = "89337899";

	public static String encrypt1(String srcStr){
		String hexStr = "";
		try {
			Charset charset = Charset.forName(ENCODE);
			char[] chars = HexUtil.encodeHex(srcStr, charset);
			hexStr = new String(chars);
		} catch (Exception e) {
			stLog(e);
		}
		return hexStr;
	}

	public static String decrypt1(String hexStr){
		Charset charset = Charset.forName(ENCODE);
		String srcStr = HexUtil.decodeHexStr(hexStr, charset);
		return (null == srcStr) ? "" : srcStr;
	}

	public static String encrypt(String srcStr) {
		String hexStr = "";
		try {
			byte[] encBytes = DESUtil.encrypt(srcStr.getBytes(ENCODE), KEY);
			hexStr = byte2Hex(encBytes);
		} catch (Exception e) {
			stLog(e);
		}
		return hexStr;
	}

	public static String decrypt(String hexStr) {
		String srcStr = "";
		try {
			byte[] decBytes = DESUtil.decrypt(hex2Byte(hexStr), KEY);
			srcStr = new String(decBytes);
		} catch (Exception e) {
			stLog(e);
		}
		return srcStr;
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

	public static void main(String[] args) {
	}

	private static void stLog(Exception e){
		log.error(e.getMessage());
		StackTraceElement[] stackTraceElements = e.getStackTrace();
		for (int i = 0; i < stackTraceElements.length; i++) {
			log.error(stackTraceElements[i].toString());
		}
	}
}
