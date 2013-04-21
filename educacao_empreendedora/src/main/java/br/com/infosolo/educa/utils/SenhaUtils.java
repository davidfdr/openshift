package br.com.infosolo.educa.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.RandomStringUtils;

public class SenhaUtils {

	public static String encrypt(String senha)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(), 0, senha.length());
		return new BigInteger(1, m.digest()).toString(16);
	}

	public static String generatePassword() {
		return RandomStringUtils.random(8, true, true);
	}
	
	public static String generateValidateKey() {
		return RandomStringUtils.random(20, true, true);
	}

}
