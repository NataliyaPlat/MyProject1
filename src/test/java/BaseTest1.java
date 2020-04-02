import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// Create Before Method and After methods to close and open browser
// //Create BaseTest file and move setup and teardown there

public class BaseTest1 {

    //public static final String USERNAME = "nataliyaplat";
    //public static final String ACCESS_KEY = "6bdbaf23-44b7-43f3-9766-51b91bd5fe37";
    //public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    //public static final String LOCALGRIDURL = "http://10.0.0.106:4455/wd/hub";

    //public static final String BROWSERUSERNAME = "europlatinummail1";
    //public static final String BROWSERACCESS_KEY = "Wxy4woeqybKbBPs1STfH";
    //public static final String BROWSERSTACKURL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";



    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;
    @BeforeMethod
    @Parameters("URL")
        public void setUp() throws MalformedURLException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        // options.addArguments("headless");
       // driver = new ChromeDriver(options);
        driver = new RemoteWebDriver(new URL("https://10.0.0.106:4455/wd/hub"), options);
        driver.manage().window().maximize();
        //driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 4);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}

