package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage (WebDriver givendriver){
        driver = givendriver;
        wait = new WebDriverWait(driver,4);
        PageFactory.initElements(givendriver, this);
    }
    //protected WebElement findElement(String cssSelector){
      //  return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    //}
    //protected void clickToElement(String cssSelector){
      //  WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        //el.click();
    //}
    protected void clickToElementByXPath(String xpath){
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        el.click();
    }
    public String getTitle(){
        return driver.getTitle();
    }
}
