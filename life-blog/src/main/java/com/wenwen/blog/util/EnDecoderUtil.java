package com.wenwen.blog.util;
//引入相关包

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//引入第三方包
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * @Author wwl
 * @Date 2021/3/14 19:05
 * @Version 1.0
 **/
public class EnDecoderUtil {
    //--------------AES---------------
    private static final String KEY = "f4k9f5w7f8g4er26";  // 密匙，必须16位
    private static final String OFFSET = "5e8y6w45ju8w9jq8"; // 偏移量
    private static final String ENCODING = "UTF-8"; // 编码
    private static final String ALGORITHM = "AES"; //算法
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding"; // 默认的加密算法，CBC模式

    //---------------MD5-------------------
    private static final String MD5KEY = "f4k9f5w7f8g4er26";  // 密匙

    /**
     * AES加密
     * @param data 需要加密数据
     * @return 加密后的数据
     * @author Owen
     */
    public static String AESEncrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecretKeySpec sKeySpec = new SecretKeySpec(KEY.getBytes("ASCII"), ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(OFFSET.getBytes());//CBC模式偏移量IV
        cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, iv);
        byte[] encrypted = cipher.doFinal(data.getBytes(ENCODING));
        return new Base64().encodeToString(encrypted);//加密后再使用BASE64做转码
    }

    /**
     * AES解密
     * @param data 需要解密数据
     * @return 解密后的数据
     * @author Owen
     */
    public static String AESDecrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        SecretKeySpec sKeySpec = new SecretKeySpec(KEY.getBytes("ASCII"), ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(OFFSET.getBytes()); //CBC模式偏移量IV
        cipher.init(Cipher.DECRYPT_MODE, sKeySpec, iv);
        byte[] buffer = new Base64().decode(data);//先用base64解码
        byte[] encrypted = cipher.doFinal(buffer);
        return new String(encrypted, ENCODING);
    }

    //---------------------MD5--------------------

    /**
     * MD5方法
     *
     * @param text 明文
     * @return 密文
     * @author Owen
     */
    public static String MD5encrypt(String text) throws Exception {
        //加密后的字符串
        return DigestUtils.md5Hex(text + MD5KEY);
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5  密文
     * @return true/false
     * @author  Owen
     */
    public static boolean verify(String text, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = MD5encrypt(text);
        return md5Text.equalsIgnoreCase(md5);
    }
}
