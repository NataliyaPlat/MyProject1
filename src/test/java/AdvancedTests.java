import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
// implementation of advanced methods in my tests
public class AdvancedTests extends BaseTest1{
    @Test
    public void  multipleTabs(){
        driver.get("https://kwidos.tk/share");
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[contains(text(), 'Twitter')]")).click();
        driver.switchTo().window(mainWindow);
    }
    @Test
    public void scrolling(){
        driver.get("https://kwidos.tk/contractor/search");
        WebElement job = driver. findElement(By.xpath("//*[contains(text(), 'NEU')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", job);
    }
    @Test
    public void keyTest(){
        driver.get("https://kwidos.com/auth/login");
        Actions builder = new Actions(driver);

        WebElement element = driver.findElement(By.cssSelector("#email"));
        Action seriesOfActions = builder
                .moveToElement(element)
                .click()
                .sendKeys(element, "hello")
                .doubleClick(element)
                .contextClick()
                .build();
        seriesOfActions.perform();
    }
    @Test
    public void hover(){
        driver.get("https://chercher.tech/practice-pop-ups-selenium-webdriver");
        Actions builder = new Actions(driver);

        WebElement element = driver.findElement(By.cssSelector("#sub-menu"));
        Action mouseOverHome = builder.moveToElement(element).build();
        mouseOverHome.perform();
        driver.findElement(By.cssSelector("#link2")).click();
    }
    @Test
    public void frame(){
        driver.get("https://testpro.io");
        driver.switchTo().frame(0).findElement(By.cssSelector("#mapDiv"));
    }
}

