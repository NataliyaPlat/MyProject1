import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest1 {

    @Test
    public void titleTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.openPage();
        String title = homePage.getTitle();
        Assert.assertEquals(title, "Kwidos");
    }
}
