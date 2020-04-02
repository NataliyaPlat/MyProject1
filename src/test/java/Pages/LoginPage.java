package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "[type = 'submit']")
    private WebElement submitButton;

    @FindBy(css = "/alert.alert-danger")
    private WebElement successText;

    public LoginPage (WebDriver givendriver){
       super(givendriver);
    }

    public String getSuccessText(){
        return successText.getText();
    }
    public String getErrorText (String cssSelector) {
        // String actualText = driver.findElement(By.cssSelector(cssSelector)).getText();
        String actualText=  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).getText();
        return actualText;
    }
    public LoginPage openPage() {
        driver.get("https://kwidos.com/auth/login");
        return this;
    }
    public LoginPage enterEmail(String email) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email"))).sendKeys(email);
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password"))).sendKeys(password);
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
        submitButton.click();
        return this;
    }
    public LoginPage login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        return this;
    }

}
