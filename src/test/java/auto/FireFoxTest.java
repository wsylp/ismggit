package auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxTest {
    public static void main(String[] args) {
        // 如果火狐浏览器没有默认安装在C盘，需要自己确定其路径
        System.setProperty("webdriver.firefox.bin", "E:\\usualtools\\internet\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "F:\\driver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        // 初始化一个chrome浏览器实例，实例名称叫driver
        WebDriver driver = new FirefoxDriver();
        // 最大化窗口
        driver.manage().window().maximize();
        // 设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // get()打开一个站点
        driver.get("https://www.baidu.com");
        // getTitle()获取当前页面title的值
        System.out.println("当前打开页面的标题是： " + driver.getTitle());

        // 关闭并退出浏览器
        driver.quit();
    }
}
