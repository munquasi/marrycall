package com.muka.marry.util;

import java.security.MessageDigest;

public class PasswordEncryptUtil {

	public static String getSha256Hash(String passwordToHashAndSalt) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(passwordToHashAndSalt.getBytes());
			return bytesToHex(md.digest());
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuffer result = new StringBuffer();
		for (byte b : bytes) {
			result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}
		return result.toString();
	}

}
