package study.javautil;

import java.util.HashSet;

/**
 * Created by wsylp on 2017/9/18.
 */
public class FirstHashSet {

    public static void main(String[] args) {
        //容量16 负载因子0.75
        HashSet<String> set = new HashSet<String>();
        set.add("语文");
        set.add("数学");
        set.add("英语");
        set.add("历史");
        set.add("政治");
        set.add("地理");
        set.add("生物");
        set.add("化学");
    }
}
