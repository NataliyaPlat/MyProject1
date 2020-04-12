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
        getDriver().get("https://kwidos.tk/share");
        String mainWindow = getDriver().getWindowHandle();
        getDriver().findElement(By.xpath("//*[contains(text(), 'Twitter')]")).click();
        getDriver().switchTo().window(mainWindow);
    }
    @Test
    public void scrolling(){
        getDriver().get("https://kwidos.tk/contractor/search");
        WebElement job = getDriver(). findElement(By.xpath("//*[contains(text(), 'NEU')]"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView()", job);
    }
    @Test
    public void keyTest(){
        getDriver().get("https://kwidos.com/auth/login");
        Actions builder = new Actions(getDriver());

        WebElement element = getDriver().findElement(By.cssSelector("#email"));
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
        getDriver().get("https://chercher.tech/practice-pop-ups-selenium-webdriver");
        Actions builder = new Actions(getDriver());

        WebElement element = getDriver().findElement(By.cssSelector("#sub-menu"));
        Action mouseOverHome = builder.moveToElement(element).build();
        mouseOverHome.perform();
        getDriver().findElement(By.cssSelector("#link2")).click();
    }
    @Test
    public void frame(){
        getDriver().get("https://testpro.io");
        getDriver().switchTo().frame(0).findElement(By.cssSelector("#mapDiv"));
    }
}


