package org.yfcloud.examination.system.config;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by wangxy on 19/12/6.
 */
public class AesEncryptUtils {

    //�����õ�Constant�У�����ȡ�����ļ�ע��
    private static final String KEY = "abcdef0123456789";


    //�����ֱ���� �㷨����/����ģʽ/������䷽ʽ
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     * ����
     * @param content ���ܵ��ַ���
     * @param encryptKey keyֵ
     * @return
     * @throws Exception
     */
    public static String encrypt(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
        byte[] b = cipher.doFinal(content.getBytes("utf-8"));
        return Base64.encodeBase64String(b);
    }

    /**
     * ����
     * @param encryptStr ���ܵ��ַ���
     * @param decryptKey ���ܵ�keyֵ
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptStr, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] encryptBytes = Base64.decodeBase64(encryptStr);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

    public static String encrypts(String content) throws Exception {
        return encrypt(content, KEY);
    }
    public static String decrypts(String encryptStr) throws Exception {
        return decrypt(encryptStr, KEY);
    }

}
