package encrpy;

import com.sun.mail.util.BASE64EncoderStream;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;
import wsylp.util.DateUtils;
import wsylp.util.encrypt.AESUtils;

/**
 * Created by wsylp on 2017/6/27.
 */
public class TestEncrypt {

    public static void main(String[] args) {
        String loginName = "admin";
        String password = "123456";
        String bankCode = "070667999";

        Date date = new Date();
        long a = date.getTime();

        byte[] key = AESUtils.initKey(128);

        byte[] keys = Base64.encodeBase64(key);
        String key64 = new String(keys);
        System.out.println("key64:" + key64);
        String data = "loginName=admin;password=123456;bankCode=070667999;" + a;
        System.out.println("加密的数据为" + data);
        byte[] ebStr = AESUtils.encrypt(data.getBytes(), key);
        byte[] b = Base64.encodeBase64(ebStr);
        String c = new String(b);
        System.out.println(c);

        //解密
        byte[] d = Base64.decodeBase64(c.getBytes());

        byte[] f = Base64.decodeBase64(keys);
        byte[] g = AESUtils.decrypt(d, f);
        String h = new String(g);
        System.out.println("最终结果:" + h);

        for (int i = 0; i < 10; i++) {
            byte[] key1 = AESUtils.initKey(128);

            byte[] keys1 = Base64.encodeBase64(key1);
            String key641 = new String(keys1);
            System.out.println("key64:" + key641);
        }

    }


    /**
     * BASE64解密
     */
    public static String decryptBASE64(String key) {
        byte[] b1 = Base64.decodeBase64(key);
        return new String(b1);
    }

    /**
     * BASE64加密
     */
    public static String encryptBASE64(String key) {
        byte[] b = Base64.encodeBase64(key.getBytes(), true);
        String str = new String(b);
        return str;
    }

}
