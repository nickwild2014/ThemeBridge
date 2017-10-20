package com.bs.themebridge.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.log4j.Logger;

/**
 * <p>
 * <li>Not used in Kotak Bank Implementation</li>
 * <li>Encryption / Decryption</li>
 * </p>
 * 
 * @author Prasath Ravichandran
 *
 */
public class EncryptionUtil {

	private final static Logger logger = Logger.getLogger(ServiceProcessorUtil.class);

	/**
	 * Method decryptString to decrypt the input
	 * 
	 * @param input
	 * @return
	 */
	public static String decryptString(String input) {
		String eKey = ThemeConstant.ENCRYPTION_UTIL_EKEY;
		String decryptedValue = "";

		try {
			decryptedValue = decrpyt(eKey, input);
		} catch (InvalidKeyException e) {
			logger.error("InvalidKey Exception : " + e);
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithm Exception: " + e);
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			logger.error("NoSuchPadding Exception : " + e);
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			logger.error("InvalidKeySpec Exception : " + e);
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			logger.error("IllegalBlockSize Exception : " + e);
			e.printStackTrace();
		} catch (BadPaddingException e) {
			logger.error("BadPadding Exception : " + e);
			e.printStackTrace();
		} catch (Exception exp) {
			logger.error(" ignore this ");
		}

		return decryptedValue;

	}

	/**
	 * Method encryptString to encrypt the string
	 * 
	 * @param input
	 *            : parameter to be encrypted.
	 * @return: Encrypted value for the input.
	 */
	public static String encryptString(String input) {
		String eKey = ThemeConstant.ENCRYPTION_UTIL_EKEY;
		String encryptedValue = "";

		try {
			encryptedValue = encrpyt(eKey, input);
		} catch (InvalidKeyException e) {
			logger.error("InvalidKey Exception : " + e);
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithm Exception  : " + e);
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			logger.error("NoSuchPadding Exception : " + e);
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			logger.error("InvalidKeySpec Exception : " + e);
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			logger.error("IllegalBlockSize Exception  : " + e);
			e.printStackTrace();
		} catch (BadPaddingException e) {
			logger.error("BadPadding Exception  : " + e);
			e.printStackTrace();
		} catch (Exception exp) {
			logger.debug(" ignore this ");
		}

		return encryptedValue;

	}

	/**
	 * Method generateKey to generate key
	 * 
	 * @return generated key
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * 
	 */
	public String generateKey() throws NoSuchAlgorithmException, InvalidKeySpecException {

		KeyGenerator keygen = KeyGenerator.getInstance("DESede");
		SecretKey key = keygen.generateKey();
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		DESedeKeySpec keyspec = (DESedeKeySpec) keyfactory.getKeySpec(key, DESedeKeySpec.class);
		return bytesToHex(keyspec.getKey());
	}

	/**
	 * Method bytesToHex
	 * 
	 * to convert bytes to hex
	 * 
	 * @param bytes
	 *            : input byte array
	 * @return string
	 */
	private static String bytesToHex(byte[] bytes) {

		StringBuffer sb = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			int v = bytes[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * Method hexToBytes
	 * 
	 * to convert hex to bytes
	 * 
	 * @param bytes
	 *            : input hex
	 * @return byte
	 */
	public static byte[] hexToBytes(String hex) {

		byte[] b = new byte[hex.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(hex.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}

	/**
	 * Method bytesToKey
	 * 
	 * to convert byte to key
	 * 
	 * @param bytes
	 *            :
	 * @return secret key object
	 */

	private static SecretKey bytesToKey(byte[] bytes)
			throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {

		DESedeKeySpec keyspec = new DESedeKeySpec(bytes);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyfactory.generateSecret(keyspec);
		return key;
	}

	/**
	 * Method encrpyt
	 * 
	 * to encrypt the input data
	 * 
	 * @param key
	 *            : input key
	 * @param data
	 *            : input data
	 * @return encrypted string
	 */

	public static String encrpyt(String key, String data) throws NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {

		// Create and initialize the encryption engine
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, bytesToKey(hexToBytes(key)));

		return bytesToHex(cipher.doFinal(data.getBytes()));

	}

	/**
	 * Method decrpyt
	 * 
	 * to decrypt the encrypted input
	 * 
	 * @param key
	 *            : input key
	 * @param data
	 *            :input data
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeySpecException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * 
	 * @return decrypted string
	 */
	public static String decrpyt(String key, String data) throws NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
		// Create and initialize the encryption engine
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.DECRYPT_MODE, bytesToKey(hexToBytes(key)));

		return new String(cipher.doFinal(hexToBytes(data)));
	}

	/**
	 * Method encryptPassword
	 * 
	 * @param plaintext
	 *            : text input
	 * @return encrypted password
	 */

	public static synchronized String encryptPassword(String plaintext) throws Exception {
		MessageDigest msgDigest = null;
		String hashValue = null;
		String algorithm = "MD5";
		String encoding = "UTF-16";
		try {
			msgDigest = MessageDigest.getInstance(algorithm);
			msgDigest.update(plaintext.getBytes(encoding));
			byte rawByte[] = msgDigest.digest();
			// hashValue = (new BASE64Encoder()).encode(rawByte);
		} catch (NoSuchAlgorithmException e) {
			logger.error("No Such Algorithm Exists");
		} catch (UnsupportedEncodingException e) {
			logger.error("The Encoding Is Not Supported");
		}
		return hashValue;
	}

}