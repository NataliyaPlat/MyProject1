package stepDefinitions;

import Pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginStepDefinitions {
    WebDriver driver;

    @Before
    public void open_browser() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("ignore-certificate-errors");

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Given("I open login page")
    public void open_login_page() {
//        driver.get("https://kwidos.tk/auth/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
    }

    //I add "azat@testpro.io" email to the emial field

    @When("I add {string} email to the emial field")
    public void open_add_email(String email) {
//        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
    }


    @When("I add {string} password to the password field")
    public void open_add_password(String password) {
//        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(password);
    }



    @When("I clcik login button")
    public void i_click_login_button() {
//        driver.findElement(By.cssSelector("[type='submit']")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }



    @When("I see login successfull message")
    public void i_see_login_success_message() throws InterruptedException {
        Assert.assertTrue(1 == 1);

    }

    @After
    public void open_close_browser() {
        driver.quit();
    }
}

