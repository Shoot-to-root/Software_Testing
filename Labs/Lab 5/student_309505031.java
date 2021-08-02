import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class student_309505031 {
    public static void scenario_a(WebDriver driver) {
        driver.findElement(By.linkText("消息")).click();
        WebElement news = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.clearfix:nth-child(1) > ul:nth-child(2) > li:nth-child(1)")));
        news.click();
        WebElement firstNewsTitle = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".single-post-title")));
        System.out.println(firstNewsTitle.getText());
        WebElement firstNewsContent = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/main/div/div/div/article/div")));
        List<WebElement> all_p = firstNewsContent.findElements(By.tagName("p"));
        for (WebElement p: all_p)
            System.out.println(p.getText());
    }

    public static void scenario_b(WebDriver driver) {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        WebElement textbox = driver.findElement(By.name("q"));
        textbox.sendKeys("309505031");
        textbox.submit();
        WebElement secondResult = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.g:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > h3:nth-child(2)")));
        System.out.println(secondResult.getText());
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.get("https://www.nycu.edu.tw/");
        driver.manage().window().maximize();

        scenario_a(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        scenario_b(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }
}
