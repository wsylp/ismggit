package auto;

import java.util.List;

import javax.swing.JScrollBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        System.out.println("该标签的属性为："+loginNameE.getAttribute("type"));
        
        // 密码标签
        WebElement passwordE = driver.findElement(By.id("password"));
        passwordE.sendKeys("123456");

        // 获取按钮
        WebElement loginE = driver.findElements(By.name("login")).get(0);
       // loginE.click();
        
        //根据class进行获取
        List<WebElement> elementsByClassName = driver.findElements(By.className("form-control"));
        System.out.println("标签class为form-control的个数为"+elementsByClassName.size());
        
        //根据css选择器进行获取
        List<WebElement> elementsByCssSelector = driver.findElements(By.cssSelector(".content .login-form .form-group .form-control-solid"));
        System.out.println("css 为 .content .login-form .form-group .form-control-solid 的个数为："+elementsByCssSelector.size());
        
        //进行登录
        loginE.click();
        
        
        //根据链接的全部文字获取
        WebElement elementByLinkText = driver.findElement(By.linkText("音乐"));
        System.out.println("根据链接文本查询的标签名为："+elementByLinkText.getTagName());
        //点击音乐按钮
        elementByLinkText.click();
        
        
        //根据链接的部分文字获取
        WebElement elementByPartialLinkText = driver.findElement(By.partialLinkText("排行"));
        System.out.println("根据链接部分文本查询的文本为："+elementByPartialLinkText.getText());
       
        
        //点击排行榜
        elementByPartialLinkText.click();;
        
        //根据标签名称进行获取
         List<WebElement> elementsByTagName = driver.findElements(By.tagName("li"));
         System.out.println("根据标签名称获取的标签个数为：" + elementsByTagName.size());
        
        /*
        //根据xptath进行获取
        driver.findElements(By.xpath(""));
        
        
       
        */
      driver.close();
        

    }
}
