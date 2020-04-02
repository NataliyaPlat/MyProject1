
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MySweetProgram extends BaseTest1{
    @Test
    public void titleTest() {
        driver.get("https://www.kwidos.tk/");
        String title = driver.getTitle();
        assertEquals(title, "Kwidos");
    }
    @Test
    public void ServiceProviderRegistrationTest() {
        driver.get("https://kwidos.tk/auth/register/contractor");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']"))).sendKeys("Nataliya");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='lastName']"))).sendKeys("Platonova");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='businessName']"))).sendKeys("Drowa");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='phone']"))).sendKeys("8897653216");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='email']"))).sendKeys("drowa1582@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='password']"))).sendKeys("Newjob2020!!");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger"))).getText();
        assertEquals(actualText, "Username or password is incorrect");
    }
}





