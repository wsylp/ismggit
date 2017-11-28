package wsylp.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * webdriver工具类
 * 
 * @author wsylp
 *
 */
public class WebDriverUtil {
    
    public static WebDriver getFirefoxWebDriver() {
        // 如果火狐浏览器没有默认安装在C盘，需要自己确定其路径
        System.setProperty("webdriver.firefox.bin", "E:\\usualtools\\internet\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "F:\\driver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        return setDefautProperty(new FirefoxDriver());
    }
    
    public static WebDriver getChromeWebDriver() {
        //谷歌浏览器采用的是默认的安装地址，不用进行指定路径
        System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver_win32\\chromedriver.exe");
        return setDefautProperty(new ChromeDriver());
    }
    
    public static WebDriver setDefautProperty(WebDriver driver) {
        // 最大化窗口
        driver.manage().window().maximize();
        // 设置隐性等待时间
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        return driver;

    }
}
