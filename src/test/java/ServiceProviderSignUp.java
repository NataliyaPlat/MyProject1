import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ServiceProviderSignUp extends BaseTest1{
    @DataProvider(name="ServiceRegistrationData")
    public Object [][] getDataFromDataProvider(){
        return new Object [][]{
                {"Nataliya", "Platonova", "Drowa", "8897653216", "europlatinum@mail.ru", ""},
                {"Nataliya", "Platonova", "Drowa", "8897653216", "europlatinum@mail.ru", "Newjob2020!!"},
                {"Nataliya", "Platonova", "Drowa", "8897653216", "", "Newjob2020!!"},
                {"Nataliya", "Platonova", "Drowa", "8897653216", "europlatinum@mail.ru", "New"}
        };
    }
    @Test(dataProvider = "ServiceRegistrationData")
    public void ServiceProviderRegistartionTest (String firstName, String lastName, String BN, String PN, String email, String password) throws InterruptedException {
        driver.get("https://kwidos.tk/auth/register/contractor");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']"))).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='lastName']"))).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='businessName']"))).sendKeys(BN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='phone']"))).sendKeys(PN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='email']"))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='password']"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='col-lg-12 col-xs-12 col-md-12 checkbox-block'] p-checkbox"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[type='submit']")).isEnabled());
        //String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText(), expErrorText();
        // Assert.assertEquals (actualText, "Username or password is incorrect");

    }
}
