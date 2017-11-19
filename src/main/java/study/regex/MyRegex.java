package study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 反射学习
 * Created by wsylp on 2017/11/14.
 */
public class MyRegex {

    public static void main(String[] args) {
        // simpleMatches();
        //  simpleCompile();
        //simpleSplit();
        //simpleLookAt();
        //simpleFind();
        //simpleReset();
        // simpleGroup();
        //simpleReplace();
     //   simpleAppend();
        testChar();
    }

    private static void testChar() {
        String text = "A  Text sep With sep Many sep Separators" + (char) 2;
        String patternString1 = "\\x02";
        Pattern pattern = Pattern.compile(patternString1);

        String[] split = pattern.split(text);
        System.out.println("split.length = " + split.length);
        for (String element : split) {
            System.out.println("element = " + element);
        }
    }

    /**
     * appendReplacement() 和 appendTail() 方法用于替换输入文本中的字符串短语，同时把替换后的字符串附加到一个 StringBuffer 中。
     *
     * 当find() 方法找到一个匹配项时，可以调用 appendReplacement() 方法，这会导致输入字符串被增加到StringBuffer 中，而且匹配文本被替换。
     * 从上一个匹配文本结尾处开始，直到本次匹配文本会被拷贝。
     *
     * appendReplacement() 会记录拷贝StringBuffer 中的内容，可以持续调用find(),直到没有匹配项。
     *
     * 直到最后一个匹配项目，输入文本中剩余一部分没有拷贝到 StringBuffer. 这部分文本是从最后一个匹配项结尾，到文本末尾部分。通过调用 appendTail()
     * 方法，可以把这部分内容拷贝到 StringBuffer 中.
     */
    private static void simpleAppend() {
        String text = "John writes about this, and John Doe writes about that,"
            + " and John Wayne writes about everything.";

        String patternString1 = "((John) (.+?)) ";
        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "Joe Blocks ");
            System.out.println(stringBuffer.toString());
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());
    }

    private static void simpleReplace() {
        String text = "John writes about this, and John Doe writes about that,"
            + " and John Wayne writes about everything.";
        String patternString1 = "((John) (.+?)) ";
        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);

        String replaceAll = matcher.replaceAll("Joe Blocks ");
        System.out.println("replaceAll   = " + replaceAll);

        String replaceFirst = matcher.replaceFirst("Joe Blocks ");
        System.out.println("replaceFirst = " + replaceFirst);
    }


    /**
     * 假设想在一个文本中查找URL链接，并且想把找到的链接提取出来。当然可以通过 start()和 end()方法完成。但是用group()方法更容易些。
     *
     * 分组在正则表达式中用括号表示，例如:
     *
     * (John)
     *
     * 此正则表达式匹配John, 括号不属于要匹配的文本。括号定义了一个分组。当正则表达式匹配到文本后，可以访问分组内的部分。
     *
     * 使用group(int groupNo) 方法访问一个分组。一个正则表达式可以有多个分组。每个分组由一对括号标记。想要访问正则表达式中某分组匹配的文本，可以把分组编号传入
     * group(int groupNo)方法。
     *
     * group(0) 表示整个正则表达式，要获得一个有括号标记的分组，分组编号应该从1开始计算。
     *
     * 多分组
     *
     * 上面提到，一个正则表达式可以有多个分组，例如：
     *
     * (John) (.+?)
     *
     * 这个表达式匹配文本”John” 后跟一个空格,然后跟1个或多个字符，最后跟一个空格。你可能看不到最后的空格。
     *
     * 这个表达式包括一些字符有特别意义。字符 点 . 表示任意字符。 字符 + 表示出现一个或多个，和. 在一起表示 任何字符,出现一次或多次。字符? 表示 匹配尽可能短的文本。
     *
     * 嵌套分组
     *
     * 在正则表达式中分组可以嵌套分组，例如
     *
     * ((John) (.+?))
     *
     * 这是之前的例子，现在放在一个大分组里.(表达式末尾有一个空格)。
     *
     * 当遇到嵌套分组时, 分组编号是由左括号的顺序确定的。上例中，分组1 是那个大分组。分组2 是包括John的分组，分组3 是包括 .+? 的分组。当需要通过groups(int
     * groupNo) 引用分组时
     */
    private static void simpleGroup() {
        String text = "John writes about this, and John Doe writes about that,"
            + " and John Wayne writes about everything.";
        String patternString1 = "(John)(.+?) ";
        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            // System.out.println("found: " + matcher.group(1) + " " + matcher.group(2));
        }
        //嵌套分组
        String text1 = "John writes about this, and John Doe writes about that,"
            + " and John Wayne writes about everything.";
        String patternString2 = "((John) (.+?)) ";
        Pattern pattern2 = Pattern.compile(patternString2);
        Matcher matcher2 = pattern.matcher(text1);
        while (matcher2.find()) {
            System.out.println("found:   ");
        }
    }


    /**
     * reset() 方法会重置Matcher 内部的 匹配状态。当find() 方法开始匹配时,Matcher 内部会记录截至当前查找的距离。调用 reset() 会重新从文本开头查找。
     *
     * 也可以调用 reset(CharSequence) 方法. 这个方法重置Matcher,同时把一个新的字符串作为参数传入，用于代替创建 Matcher 的原始字符串。
     */
    private static void simpleReset() {
        String text = "This is the text which is to be searched for occurrences of the word 'is'.";
        String patternString = "is";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            Matcher reset = matcher.reset();
            System.out.println(reset);
            //   count++;
            // System.out.println("found: " + count + " : " + matcher.start() + " - " + matcher.end());
        }
    }

    /**
     * find() 方法用于在文本中查找出现的正则表达式，文本是创建Matcher时，通过 Pattern.matcher(text) 方法传入的。如果在文本中多次匹配，find()
     * 方法返回第一个，之后每次调用 find() 都会返回下一个。
     *
     * start() 和 end() 返回每次匹配的字串在整个文本中的开始和结束位置。实际上, end() 返回的是字符串末尾的后一位，这样，可以在把 start() 和 end()
     * 的返回值直接用在String.substring() 里。
     */
    private static void simpleFind() {
        String text =
            "This is the text which is to be searched " + "for occurrences of the word 'is'.";
        String patternString = "is";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("found: " + count + " : " + matcher.start() + " - " + matcher.end());
        }
    }

    /**
     * lookAt匹配的为文本开头
     */
    private static void simpleLookAt() {
        String text =
            "This is the text to be searched " + "for occurrences of the http:// pattern.";
        String patternString = "This is the";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        System.out.println("lookingAt = " + matcher.lookingAt());
        System.out.println("matches   = " + matcher.matches());
    }

    /**
     * pattern.split()
     * 用正则表达式将文本进行分割为String 类型的数组
     */
    private static void simpleSplit() {
        String text = "A  Text sep With sep Many sep Separators" + (char) 2 + "22222";
        System.out.println(text);
        String patternString = "sep";
        String a = (char) 2 + "";
        Pattern pattern = Pattern.compile(a);
        String[] split = pattern.split(text);
        System.out.println("split.length = " + split.length);
        for (String element : split) {
            System.out.println("element = " + element);
        }
    }

    /**
     * pattern.compile
     * 匹配一个正则表达式在文本中多次出现
     */
    private static void simpleCompile() {
        String text = "This is the text to be searched for occurrences of the http:// pattern.";
        String patternString = ".*http://.*";
        Pattern pattern = Pattern.compile(patternString);
        Matcher mathes = pattern.matcher(text);
        System.out.println("mathes:" + mathes);
        boolean bln = mathes.matches();
        System.out.println(bln);
        //忽略大小写
        // Pattern pattern1 = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
    }

    /**
     * Pattern.matches() 检查一个正则表达式的模式是否匹配一段文本的最直接方法是调用静态方法
     * ".*"代表包含0个或者多个字符
     */

    private static void simpleMatches() {
        String text = "This is the text to be searched for occurrences of the http:// pattern.";
        String pattern = ".*http://.*";
        boolean mathes = Pattern.matches(pattern, text);
        System.out.println("mathes:" + mathes);
    }

}
