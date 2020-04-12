package stepDefinitions;

import Pages.HomePage;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class SignUpStepDefinitions {
    WebDriver driver;

        @Given("I open login page")
        public void open_login_page() {
            HomePage homePage = new HomePage(driver);
            homePage.openPage();
        }
    }

