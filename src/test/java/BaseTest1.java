import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
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
//running tests through Selenium Grid
    public static final String USERNAME = "nataliyaplat";
    public static final String ACCESS_KEY = "6bdbaf23-44b7-43f3-9766-51b91bd5fe37";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public static final String LOCALGRIDURL = "http://10.0.0.106:4455/wd/hub";

    public static final String BROWSERUSERNAME = "europlatinummail1";
    public static final String BROWSERACCESS_KEY = "Wxy4woeqybKbBPs1STfH";
    public static final String BROWSERSTACKURL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";



   // WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;
    ThreadLocal<RemoteWebDriver>threadDriver;
    Capabilities capabilities;

    @BeforeMethod
    @Parameters("URL")
        public void setUp() throws MalformedURLException{
        //implementation of parallel testing
        threadDriver= new ThreadLocal<RemoteWebDriver>();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("ignore-certificate-errors");
        // options.addArguments("headless");
       // driver = new ChromeDriver(options);
       // driver = new RemoteWebDriver(new URL("https://10.0.0.106:4455/wd/hub"), options);

        //Running tests on different browsers

        SafariOptions safariOptions = new SafariOptions();
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        switch (System.getProperty("browser")){
            case "safari":
                capabilities = safariOptions;
                break;
            case "chrome":
                chromeOptions.addArguments("ignore-certificate-errors");
                capabilities=chromeOptions;
                break;
            case "firefox":
                firefoxOptions.addArguments("ignore-certificate-errors");
                capabilities=firefoxOptions;
                break;
            default:
                chromeOptions.addArguments("ignore-certificate-errors");
                capabilities=chromeOptions;
        }
        //running tests in parallel in 5 threads
        threadDriver.set(new RemoteWebDriver(new URL("https://10.0.0.106:4455/wd/hub"),capabilities));
        getDriver().manage().window().maximize();
        //driver.get(url);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(getDriver(), 4);
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
    }
    public WebDriver getDriver(){

        return threadDriver.get();
    }
    @AfterMethod
    public void tearDown(){

        getDriver().quit();
    }
}

