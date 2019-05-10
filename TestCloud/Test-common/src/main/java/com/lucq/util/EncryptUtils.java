package com.lucq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by dell on 2019/2/27.
 */
public class EncryptUtils {

    private static final Logger logger = LoggerFactory.getLogger(EncryptUtils.class);

    private static final char[] HEX_CODE = "0123456789ABCDEF".toCharArray();

    public static final String ALPHA_STR = "ABCDEFGHIJKLMNOPQRSTWVUXYZ0123456789abcdefghijklmnopqrstwvuxyz";

    private static final String  HEX_STRING = "0123456789ABCDEF";


    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_CODE[v >>> 4];
            hexChars[j * 2 + 1] = HEX_CODE[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStrToStr(String hexStr) {

        return new String(hexStrToBytes(hexStr));
    }

    /**
     * 16进制直接转换成为二进制
     * @param hexStr
     * @return
     */
    public static byte[] hexStrToBytes(String hexStr) {

        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = HEX_STRING.indexOf(hexs[2 * i]) * 16;
            n += HEX_STRING.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }

        return bytes;
    }

    public static String encodeSHA1(String text) {

        return encode(text, "SHA-1");
    }

    public static String encodeSHA256(String text) {

        return encode(text, "SHA-256");
    }

    public static String encode(String text, String algorithm) {
        String code = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(text.getBytes("UTF-8"));
            code = bytesToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            logger.error("The encodeSHA1 is error:{}", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("The encodeSHA1 is error:{}", e);
        }
        return code;
    }

    /**
     *
     * @param text
     * @param keys
     * @return
     */
    public static String encodeAES(String text, String keys) {
        String code = "";
        try {
            code = bytesToHex(encrypt(text.getBytes("utf-8"), keys, Cipher.ENCRYPT_MODE,
                    "AES", "AES/CBC/PKCS5Padding"));
        } catch (Exception e) {
            logger.error("The encodeAES is error:{}", e);
        }
        return code;
    }

    public static byte[] encrypt(byte[] bytes, String keys, Integer encryptMode,
                                 String algorithm, String algorithmPadding) {
        byte[] encrypted = null;
        try {
            byte[] raw = keys.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, algorithm);
            Cipher cipher = Cipher.getInstance(algorithmPadding);//"算法/模式/补码方式"
            IvParameterSpec iv = new IvParameterSpec(keys.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(encryptMode, skeySpec, iv);
            encrypted = cipher.doFinal(bytes);

        } catch (Exception e) {
            logger.error("The encrypt is error:{}", e);
        }
        return encrypted;
    }

    /**
     *
     * @param code
     * @param keys
     * @return
     */
    public static String decodeAES(String code, String keys) {
        String text = "";
        try {
            byte[] encrypted = encrypt(hexStrToBytes(code), keys, Cipher.DECRYPT_MODE,
                    "AES", "AES/CBC/PKCS5Padding");

            text = new String(encrypted);
        } catch (Exception e) {
            logger.error("The decodeAES is error:{}", e);
        }
        return text;
    }

    /**
     * 获取随机字符串
     * @param length
     * @return
     */
    public static String getRamdomStr(int length) {
        if (length < 1) {
            length = 16;
        }
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();

        int temp = 0;
        for (int i = 0; i < length; i++) {
            temp = secureRandom.nextInt(ALPHA_STR.length());
            stringBuilder.append(ALPHA_STR.charAt(temp));
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {


        System.out.println(getRamdomStr(64));
        System.out.println(getRamdomStr(64));
        System.out.println(getRamdomStr(64));
    }

}
