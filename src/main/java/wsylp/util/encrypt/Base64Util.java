package wsylp.util.encrypt;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by wsylp on 2017/7/1.
 */
public class Base64Util {

    /**
     * 正常编码
     * * @param data 数据
     *
     * @return 加密后的字节数组
     */
    public static byte[] encode(byte[] data) {
        byte[] bys = Base64.encodeBase64(data);
        return bys;
    }

    /**
     * 对url进行编码
     *
     * @param data 数据
     * @return 加密后的字符串
     */
    public static String encodeUrl(byte[] data) {
        String da = Base64.encodeBase64URLSafeString(data);
        return new String(da);
    }

    /**
     * 对64位base64解码
     *
     * @param str 数据
     * @return 解码后字符串
     */
    public static String decodeUrl(byte[] str) {
        byte[] da = Base64.decodeBase64(str);
        return new String(da);
    }

}
