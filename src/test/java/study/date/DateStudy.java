package study.date;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import wsylp.util.LocalDateUtil;


/**
 * Created by wsylp on 2017/9/12.
 */
public class DateStudy {

    public static void main(String[] args) {
        //输出今天日期(只有日期)
        LocalDate today = LocalDate.now();
        //today=  today.plusDays(2);
        System.out.println(today);


        //获取当前的年,月,日
        int year = today.getYear();
        System.out.println(year);
        //月
        Month month = today.getMonth();
        System.out.println(month);
        //月份
        int monthV = today.getMonthValue();
        System.out.println(monthV);
        //日期
        int day = today.getDayOfMonth();
        System.out.println("day:"+day);

       // String parse = DateUtil.parse(2017, 01, 12)+"";
        //System.out.println(parse);

        //检查重复日期
        LocalDate dataOfbirth = LocalDate.of(2010,9,12);
        MonthDay birthday = MonthDay.of(dataOfbirth.getMonth(),dataOfbirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if(currentMonthDay.equals(birthday)){
            System.out.println("many many happy returns of day");
        }

        //获取当前时间
        LocalTime time = LocalTime.now();
      //  LocalTime newTime  = time.plusHours(2);//加两个小时
        System.out.println("当前时间戳:"+time);

        //获取一周后的日期
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println(nextWeek);

        //一年前的一天
        LocalDate previous = today.minus(1,ChronoUnit.YEARS);
        System.out.println("一年前的今天:"+previous);
        //一年后的今天
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年后的今天:"+nextYear);

        //使用时钟
        Clock clock = Clock.systemUTC();
        System.out.println("clock:"+clock);

        Clock.systemDefaultZone();
        System.out.println("clock:" + clock);

        //判断日期在另一个日期的前面还是后面
        LocalDate tomorrow = LocalDate.of(2017,9,13);
        System.out.println(tomorrow);
        if(tomorrow.isAfter(today)){
            System.out.println("tomorrow is after today");
        }

        YearMonth currentYearMonth = YearMonth.now();
        //获取本月的天数
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());

        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);

        //检查闰年
        if(today.isLeapYear()){
            System.out.println("今年是闰年");
        } else {
            System.out.println("今年是平年");
        }

        //两个日期之间包含多少天数
        LocalDate java8Release = LocalDate.of(2018,Month.MARCH,14);
        Period periodToNextJavaRelease = Period.between(today,java8Release);
        System.out.println(periodToNextJavaRelease.getMonths());

        //当前时间戳
        Instant timestamp = Instant.now();
        System.out.println("当前时间戳:" + timestamp);
        System.out.println(Date.from(timestamp));


        //预定义的格式器来进行格式化
        String dayAfterTomorrow = "20170912";
        LocalDate formatted = LocalDate.parse(dayAfterTomorrow, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("格式化后的日期:" + formatted);

        //在java中使用自定义的格式器来解析日期
        String goodFriday = "九月 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }

        //将日期转换为字符转
        LocalDateTime arrivalTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
        String landing = arrivalTime.format(format);
        System.out.println("转换为字符串的为:" + landing);

        LocalDateUtil.addDate(today,ChronoUnit.DAYS,2);
    }

}
