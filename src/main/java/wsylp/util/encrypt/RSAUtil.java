package wsylp.util.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by wsylp on 2017/7/9.
 */
public class RSAUtil {

    public static HashMap<String, Object> initKey()
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyGenerator.generateKeyPair();
        //获取公钥
        PublicKey publicKey = keyPair.getPublic();
        //获取私钥
        PrivateKey privateKey = keyPair.getPrivate();
        Cipher cipher = Cipher.getInstance("RSA");
        HashMap<String, Object> map = new HashMap<>();
        map.put("publicKey", publicKey);
        map.put("privateKey", privateKey);
        return map;
    }

    /**
     * 公钥进行加密
     *
     * @param data
     * @param publicKey
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] encrypt(byte[] data, PublicKey publicKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        //公钥加密
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypt = cipher.doFinal(data);
        System.out.println("公钥加密后：" + Arrays.toString(encrypt));
        return encrypt;


    }


    /**
     * 用私钥进行解密
     *
     * @param data
     * @param privateKeyey
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static byte[] decrypt(byte[] data, PrivateKey privateKeyey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        //私钥解密
        cipher.init(Cipher.DECRYPT_MODE, privateKeyey);
        byte[] decrypt = cipher.doFinal(data);
        System.out.println("私钥解密后：" + Arrays.toString(decrypt));
        return decrypt;
    }

    /**
     * 校验数字签名
     *
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws InvalidKeySpecException
     */
    public static void checkSign()
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
        String str = "不积跬步无以至千里";
        //初始化密钥,获取公钥私钥
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //公钥
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        //私钥
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

        //进行私钥签名
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        java.security.Signature signature = java.security.Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(str.getBytes());
        byte[] res = signature.sign();
        //System.out.println("签名:"+ HexBin.encode(res));

        //验证签名的正确性
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        keyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(publicKey);
        signature.update(str.getBytes());
        boolean bool = signature.verify(res);
        System.out.println("验证：" + bool);
    }

    public static void main(String[] args)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, SignatureException, InvalidKeySpecException {
        HashMap<String, Object> map = initKey();
        PublicKey publicKey = (PublicKey) map.get("publicKey");
        PrivateKey privateKey = (PrivateKey) map.get("privateKey");
        byte[] encrypt = encrypt("不积跬步无以至千里".getBytes(), publicKey);
        byte[] decrypt = decrypt(encrypt, privateKey);
        System.out.println(new String(decrypt));
        //测试签名
        checkSign();
    }
}