package com.common.utill;

import java.util.UUID;

public class KeyGenerateUtil {
	/**
	 * 암호화에서 사용할 Salt(솔트)를 생성한다.
	 * @return Salt 문자열
	 */
	public static String getSalt() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
