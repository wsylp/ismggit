package encrpy;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 3DES加密
 * Created by wsylp on 2017/6/29.
 */
public class DES3Util {

    //生成密钥
    public static byte[] initkey() throws NoSuchAlgorithmException {
        //生成3des密钥
        KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
        //密钥长度默认为168,可以指定为112
        keyGen.init(168);
        //采用KeyGenerator规则生成密钥
        SecretKey secretKey = keyGen.generateKey();
        //生成为密钥数组
        byte[] key = secretKey.getEncoded();
        return key;
    }

    public static byte[] enectry(byte[] data, byte[] key)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        /**
         * 1:取得密钥
         * 2:实例化Cipher
         * 3:ENCRYPT_MODE模式进行加密
         */
        //取得密钥
        SecretKey secretKey1 = new SecretKeySpec(key, "DESede");
        //实例化Cipher完成加密或解密工作类
        Cipher cipher = Cipher.getInstance("DESede");

        ////对Cipher.ENCRYPT_MODE模式加密
        cipher.init(Cipher.ENCRYPT_MODE, secretKey1);
        //加密数据
        byte[] cipherByte = cipher.doFinal(data);
        return cipherByte;
    }

    public static byte[] decrypt(byte[] data, byte[] key)
        throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        /**
         * 1:取得密钥
         * 2:实例化Cipher
         * 3:Cipher.DECRYPT_MODE模式进行解密
         */
        //恢复密钥
        SecretKey secretKey = new SecretKeySpec(key, "DESede");
        //Cipher完成加密或解密工作类
        Cipher cipher = Cipher.getInstance("DES");
        //对Cipher初始化，Cipher.DECRYPT_MODE为解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        //将数据解密出来
        byte[] cipherByte2 = cipher.doFinal(data);
        return cipherByte2;
    }

}
