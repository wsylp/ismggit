package auto;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import wsylp.util.WebDriverUtil;

public class GoogleTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getChromeWebDriver();

        // 打开登录页
        driver.get("http://192.168.2.249:8080/ismg/login.html");
        // 获取title
        System.out.println("当前打开页面的标题是： " + driver.getTitle());

        // 根据id查找标签
        WebElement loginNameE = driver.findElement(By.id("loginName"));
        loginNameE.sendKeys("admin");
        System.out.println("该标签的属性为：" + loginNameE.getAttribute("type"));

        // 密码标签
        WebElement passwordE = driver.findElement(By.id("password"));
        passwordE.sendKeys("123456");

        // 获取按钮
        WebElement loginE = driver.findElements(By.name("login")).get(0);
        // loginE.click();

        // 根据class进行获取
        List<WebElement> elementsByClassName = driver.findElements(By.className("form-control"));
        System.out.println("标签class为form-control的个数为" + elementsByClassName.size());

        // 根据css选择器进行获取
        List<WebElement> elementsByCssSelector = driver
                .findElements(By.cssSelector(".content .login-form .form-group .form-control-solid"));
        System.out.println(
                "css 为 .content .login-form .form-group .form-control-solid 的个数为：" + elementsByCssSelector.size());

        // 进行登录
        loginE.click();

        // 根据链接的全部文字获取
        WebElement elementByLinkText = driver.findElement(By.linkText("音乐"));
        System.out.println("根据链接文本查询的标签名为：" + elementByLinkText.getTagName());
        // 点击音乐按钮
        elementByLinkText.click();

        // 根据链接的部分文字获取
        WebElement elementByPartialLinkText = driver.findElement(By.partialLinkText("排行"));
        System.out.println("根据链接部分文本查询的文本为：" + elementByPartialLinkText.getText());

        // 点击排行榜
        elementByPartialLinkText.click();

        // 根据标签名称进行获取
        List<WebElement> elementsByTagName = driver.findElements(By.tagName("li"));
        System.out.println("根据标签名称获取的标签个数为：" + elementsByTagName.size());

        // 进行查找一下排行榜的位置
        // 根据xptath进行获取
        /**
         * xpath是XMl path的简称,在谷歌浏览器中定位到元素，在调试框中右击，选中copy,就可以看到Copy Xpath
         * 
         * 使用这种方式的缺点就是速度慢，在保证上面定位不到元素的时候，可以考虑使用这种方式。 xpath
         * 的路径有两种方式，一种是绝对路径是以"/"开头的，xpat从根节点进行解析 二种是相对路径，以"/"开始的，让xpath从文档的任何元素节点进行解析
         * 
         */
        // 绝对定位/html/body/div/header/nav/div/div[2]/ul/li[2]/ul/li[1]/a
        // 中的[2]表示为索引号（第二个div）
        WebElement elementByXpath = driver
                .findElement(By.xpath("/html/body/div/header/nav/div/div[2]/ul/li[2]/ul/li[1]/a"));
        System.out.println("跟据xpath获取的第一个标签为：" + elementByXpath.getText());
        // 相对定位 @class 为i标签的属性
        WebElement elementByXpath2 = driver
                .findElement(By.xpath("//nav/div/div[2]/ul/li[2]/ul/li[1]/a/i[@class='icon-diamond']"));
        System.out.println("跟据xpath相对路径class属性获取的标签为：" + elementByXpath2.getTagName());

        // 模糊定位 格式为 标签[starts-with(@属性,'值')] i[starts-with(@class,'icon')]
        WebElement elementByXpath3 = driver
                .findElement(By.xpath("//nav/div/div[2]/ul/li[2]/ul/li[1]/a/i[starts-with(@class,'icon')]"));
        System.out.println("跟据xpath相对路径starts-with查询标签为：" + elementByXpath3.getTagName());

        // 模糊定位 包含 格式为 标签[contains(@属性,'值')] i[contains-with(@class,'icon')]
        WebElement elementByXpath4 = driver
                .findElement(By.xpath("//nav/div/div[2]/ul/li[2]/ul/li[1]/a/i[contains(@class,'diamond')]"));
        System.out.println("跟据xpath相对路径contains查询标签为：" + elementByXpath4.getTagName());

        // text() 函数文本定位
        WebElement elementByXpath5 = driver.findElement(By.xpath("//*[text()='Hi, 超级管理员']"));
        System.out.println("跟据xpath相对路径text()函数查询  标签为：" + elementByXpath5.getTagName());

        // contains text() 函数文本定位
        WebElement elementByXpath6 = driver.findElement(By.xpath("//span[contains(text(),'Hi')]"));
        System.out.println("跟据xpath相对路径contains text()函数查询  标签为：" + elementByXpath6.getTagName());
        driver.close();

    }

    public void doWebUI() {
        WebDriver driver = WebDriverUtil.getChromeWebDriver();
        driver.get("http://192.168.2.249:8080/ismg/login.html");

        // 根据链接的部分文字获取
        WebElement elementByPartialLinkText = driver.findElement(By.partialLinkText("排行"));
        // 点击事件
        elementByPartialLinkText.click();

        // 输入框
        WebElement loginNameE = driver.findElement(By.id("loginName"));
        // 输入操作
        loginNameE.sendKeys("admin");
        // 清空操作
        loginNameE.clear();
        // 获取输入框的内容
        loginNameE.getAttribute("value");

        // 获取按钮
        WebElement loginE = driver.findElements(By.name("login")).get(0);
        // 按钮点击事件
        loginE.click();
        // 判断按钮是否禁用
        loginE.isEnabled();

        // 找到元素（项目中暂时没有下拉框）
        Select select = new Select(driver.findElement(By.id("proAddItem_kind")));
        // 选择对应的选择项， index 从0开始的
        select.selectByIndex(2);
        select.selectByValue("18");
        select.selectByVisibleText("种类AA");

        // 获取所有的选项
        List<WebElement> options = select.getOptions();
        for (WebElement webElement : options) {
            System.out.println(webElement.getText());
        }

        // 找到单选框元素
        String xpath = "//input[@type='radio'][@value='Apple']";
        WebElement apple = driver.findElement(By.xpath(xpath));
        // 选择某个单选框
        apple.click();
        // 判断某个单选框是否已经被选择
        @SuppressWarnings("unused")
        boolean isAppleSelect = apple.isSelected();
        // 获取元素属性
        apple.getAttribute("value");

        // 多选框与单选框一样

    }

    /**
     * 操作浏览器
     */
    public static void testBrowser(WebDriver driver) throws Exception {
        driver.get("http://www.cnblogs.com/tankxiao");
        Thread.sleep(5000);
        // 浏览器最大化
        driver.manage().window().maximize();

        driver.navigate().to("http://www.baidu.com");
        // 刷新浏览器
        driver.navigate().refresh();
        // 浏览器后退
        driver.navigate().back();
        // 浏览器前进
        driver.navigate().forward();
        // 浏览器退出
        driver.quit();
    }

    /**
     * 截图操作
     * 
     * @param driver
     * @throws Exception
     */
    public static void testScreenShot(WebDriver driver) throws Exception {
        driver.get("http://www.baidu.com");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("c:\\1.png"));
    }

    /**
     * 模拟鼠标操作
     * 
     * @param driver
     */
    public static void rightClickMouse(WebDriver driver) {
        driver.get("http://www.baidu.com");
        Actions action = new Actions(driver);

        action.contextClick(driver.findElement(By.id("kw"))).perform();
    }

    /**
     * 杀掉windows浏览器进程
     */
    public static void killProcess() {
        // kill firefox
        WindowsUtils.killByName("firefox.exe");
        // kill IE
        WindowsUtils.killByName("iexplore.exe");
        // kill chrome
        WindowsUtils.killByName("chrome.exe");
    }

    /**
     * 操作弹出对话框 提示框，警告框，确认框
     */

    public static void testAlert(WebDriver driver) {
        String url = "http://sislands.com/coin70/week1/dialogbox.htm";
        driver.get(url);

        WebElement alertButton = driver.findElement(By.xpath("//input[@value='alert']"));
        alertButton.click();

        Alert javascriptAlert = driver.switchTo().alert();
        System.out.println(javascriptAlert.getText());
        javascriptAlert.accept();
    }

    public static void testPrompt(WebDriver driver) throws Exception {
        String url = "http://sislands.com/coin70/week1/dialogbox.htm";
        driver.get(url);

        WebElement promptButton = driver.findElement(By.xpath("//input[@value='prompt']"));
        promptButton.click();
        Thread.sleep(2000);
        Alert javascriptPrompt = driver.switchTo().alert();
        javascriptPrompt.sendKeys("This is learning Selenium");
        javascriptPrompt.accept();

        System.out.println(javascriptPrompt.getText());

        javascriptPrompt = driver.switchTo().alert();
        javascriptPrompt.accept();

        Thread.sleep(2000);
        promptButton.click();
        javascriptPrompt = driver.switchTo().alert();
        javascriptPrompt.dismiss();
        Thread.sleep(2000);
        javascriptPrompt = driver.switchTo().alert();
        javascriptPrompt.accept();
    }

    public static void testConfirm(WebDriver driver) throws Exception {
        String url = "http://sislands.com/coin70/week1/dialogbox.htm";
        driver.get(url);

        WebElement confirmButton = driver.findElement(By.xpath("//input[@value='confirm']"));
        confirmButton.click();
        Thread.sleep(2000);
        Alert javascriptConfirm = driver.switchTo().alert();
        javascriptConfirm.accept();
        Thread.sleep(2000);
        javascriptConfirm = driver.switchTo().alert();
        javascriptConfirm.accept();
    }

    /**
     * 操作弹出框口
     */
    public static void testMultipleWindowsTitle(WebDriver driver) throws Exception {
        String url = "E:\\StashFolder\\huoli_28@hotmail.com\\Stash\\Tank-MoneyProject\\Selenium Webdriver\\AllUIElement.html";
        driver.get(url);
        // 获取当前窗口的句柄
        String parentWindowId = driver.getWindowHandle();
        System.out.println("driver.getTitle(): " + driver.getTitle());

        WebElement button = driver.findElement(By.xpath("//input[@value='打开窗口']"));
        button.click();

        Set<String> allWindowsId = driver.getWindowHandles();

        // 获取所有的打开窗口的句柄
        for (String windowId : allWindowsId) {
            if (driver.switchTo().window(windowId).getTitle().contains("博客园")) {
                driver.switchTo().window(windowId);
                break;
            }
        }

        System.out.println("driver.getTitle(): " + driver.getTitle());

        // 再次切换回原来的父窗口
        driver.switchTo().window(parentWindowId);
        System.out.println("parentWindowId: " + driver.getTitle());
    }

    /**
     * 等待 隐试等待，显示等待
     */
    public void TestWait() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///C:/Users/Tank/Desktop/set_timeout.html");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.cssSelector(".red_box"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = \"5px solid yellow\"", element);

    }

    /**
     * 显示等待
     * 
     * @param driver
     */
    public static void testWait2(WebDriver driver) {
        driver.get(
                "E:\\StashFolder\\huoli_28@hotmail.com\\Stash\\Tank-MoneyProject\\浦东软件园培训中心\\我的教材\\Selenium Webdriver\\set_timeout.html");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        // ExpectedConditions.presenceOfElementLocated(By.cssSelector(".red_box"))
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".red_box")));
        WebElement element = driver.findElement(By.cssSelector(".red_box"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = \"5px solid yellow\"", element);
    }

    /**
     * 操作Iframe
     * 
     * @param dr
     */
    public void testIframe(WebDriver dr) {
        // 进入 id 叫frameA 的 iframe
        dr.switchTo().frame("frameA");

        // 回到主窗口
        dr.switchTo().defaultContent();
    }

    public static void testIframe2(WebDriver driver) {
        driver.get(
                "E:\\StashFolder\\huoli_28@hotmail.com\\Stash\\Tank-MoneyProject\\浦东软件园培训中心\\我的教材\\Selenium Webdriver\\frame\\main.html");

        // 在 主窗口的时候
        driver.findElement(By.id("maininput")).sendKeys("main input");
        // 此时 没有进入到iframe, 以下语句会报错
        // driver.findElement(By.id("iframeinput")).sendKeys("iframe input");

        driver.switchTo().frame("frameA");
        driver.findElement(By.id("iframeinput")).sendKeys("iframe input");

        // 此时没有在主窗口，下面语句会报错
        // driver.findElement(By.id("maininput")).sendKeys("main input");

        // 回到主窗口
        driver.switchTo().defaultContent();
        driver.findElement(By.id("maininput")).sendKeys("main input");
    }
}
