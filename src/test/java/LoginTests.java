
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest1 {
    @Test
    public void LoginSuccessTest()  {
        HomePage homepage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        homePage.openPage();
        loginPage = homePage.clickToOpenSignIn().enterEmail("europlatinum@mail.ru").enterPassword("Newjob2!").clickSubmit();

        String actualText = loginPage.getSuccessText();
        Assert.assertEquals(actualText, "Success");
    }
    @Test
    public void LoginWrongCredentialTest() {
      //  fluent interface
        loginPage.openPage()
                .enterEmail("europlatinum@mail.ru")
                .enterPassword("Newjob2!")
                 .clickSubmit();
        String actualText = loginPage.getErrorText(".alert.alert-danger");
        Assert.assertEquals(actualText, "Username or password is incorrect");
    }
    @Test
    public void LoginEmptyEmailTest(){
       // LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage().enterPassword("Newjob2!").enterEmail("").clickSubmit();
        String actualText = loginPage.getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Email is required");
    }
    @Test
    public void LoginEmptyPasswordTest() {
       // LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("");
        loginPage.enterEmail("europlatinum@mail.ru");
        loginPage.openPage();
        loginPage.clickSubmit();
        String actualText = loginPage.getErrorText("[class='form-group has-error'] div");
        Assert.assertEquals(actualText, "Password is required");
    }

}
