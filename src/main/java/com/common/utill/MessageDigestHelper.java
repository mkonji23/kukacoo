package com.common.utill;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

public class MessageDigestHelper {
	/**
	 * 입력 문자열을 SHA-256 알고리즘에 salt와 반복처리로 암호화하고 Base64로 인코딩한다.
	 * @param input 입력 문자열
	 * @param salt Salt 문자열
	 * @param count 암호화 반복 횟수
	 * @return 암호화 문자열
	 */
	public static String getSHA256AsBase64(String input, String salt, int count) {
		if (input == null || input.length() == 0) {
			return "";
		}

		String digest = "";
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset();
			messageDigest.update(salt.getBytes(StandardCharsets.UTF_8));

			byte[] output = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
			for (int index = 0; index < count; index++) {
				messageDigest.reset();
				output = messageDigest.digest(output);
			}

			Encoder encoder = Base64.getEncoder();
			digest = new String(encoder.encode(output));
		} catch (NoSuchAlgorithmException e) {
			digest = "";
		}
		return digest;
	}
}
