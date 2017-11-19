package encrpy;

import wsylp.util.encrypt.Base64Util;

/**
 * Created by wsylp on 2017/7/1.
 */
public class TestBase64 {

    public static void main(String[] args) {
        String a = "我是张三";
        String b = Base64Util.encodeUrl(a.getBytes());
        String c = Base64Util.decodeUrl(b.getBytes());
        System.out.println(c);

    }
}
