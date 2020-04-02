package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage (WebDriver givendriver){
        super(givendriver);
    }
    public HomePage openPage(){
        driver.get("https://kwidos.tk/");
        return new HomePage(driver);
    }
    public LoginPage clickToOpenSignIn(){
        clickToElementByXPath("//*[contains(text(),'SIGN IN')]");
        return new LoginPage(driver);
    }
    public void clickToElement(String cssSelector){
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        el.click();
    }
}
