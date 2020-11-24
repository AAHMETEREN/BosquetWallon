package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hash {
	private static SecureRandom random = new SecureRandom();
	private static byte[] salt = new byte[16];
	private static MessageDigest md;

	public Hash() throws NoSuchAlgorithmException {
		try {
			random.nextBytes(salt);
			this.md = MessageDigest.getInstance("SHA-512");
			this.md.update(salt);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	private static byte[] getSalt() throws NoSuchAlgorithmException {
		byte[] newSalt;
		try {
			// Always use a SecureRandom generator
			random = SecureRandom.getInstance("SHA1PRNG");
			// Create array for salt
			newSalt = new byte[16];
			// Get a random salt
			random.nextBytes(salt);
			// return salt
			return newSalt;
		} catch (NoSuchAlgorithmException err) {
			System.out.println(err.getMessage());
		}
		return null;

	}

	public static String hashPassword(String passwordToHash) throws NoSuchAlgorithmException {
		salt = getSalt();
		String generatedPassword = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(salt);
			// Get the hash's bytes
			byte[] bytes = md.digest(passwordToHash.getBytes());
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	public static boolean ComparePassword(String inputPassword, String realPassword) throws NoSuchAlgorithmException {
		try {
			String hashedInputPassword = hashPassword(inputPassword);
			String hashedRealPassword = hashPassword(realPassword);

			if (hashedInputPassword.equals(hashedRealPassword)) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return false;

	}

}
