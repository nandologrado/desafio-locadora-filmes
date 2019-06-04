package br.com.moviestore.util;

import java.security.MessageDigest;
import java.util.Base64;

public class CodificaSenha {

	public static String codifca(String senha) {
		try {
			byte[] hash = MessageDigest.getInstance("SHA-256")
									   .digest(senha.getBytes());
			
			return Base64.getEncoder().encodeToString(hash);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}