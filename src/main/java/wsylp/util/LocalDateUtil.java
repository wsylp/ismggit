package wsylp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by wsylp on 2017/9/12.
 */
public class LocalDateUtil {

    /**
     * 将字符串转换为LocalDate格式
     */
    public static LocalDate parseLocalDate(String dataStr) {
        //将20170808进行从转换
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(dataStr, formatter);
        return date;
    }


    /**
     * 增加日期或者减少天数
     *
     * @param localDate 日期
     * @param type 类型 ChronoUnit.DAYS 天数,ChronoUnit.YEARS 年,ChronoUnit.WEEKS 周,ChronoUnit.MONTHS
     * 月,ChronoUnit.HOURS 小时,ChronoUnit.MINUTES 分
     */
    public static LocalDate addDate(LocalDate localDate, ChronoUnit type, int dateCount) {
        LocalDate date;

        if (dateCount >= 0) {
            date = localDate.plus(dateCount, type);
        } else {
            date = localDate.minus(dateCount, type);
        }
        return date;
    }
}
