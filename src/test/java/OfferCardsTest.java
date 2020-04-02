import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
//1. Assert only 10 cards appears on page

public class OfferCardsTest extends BaseTest1 {

    @Test
    public void OfferListSizeTest () {
        driver.get("https://kwidos.tk/offer/search");
        List<WebElement> cardLists = (List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='card-shape']")));
        Assert.assertEquals(cardLists.size(),10);
    }
    //2. Filter by service type and make sure that only services with given service type are shown on the page


    @Test
    public void FilterByServiceTypeTest() {
        driver.get("https://kwidos.tk/offer/search");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Service Type')]/../p-multiselect"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), '3D Capture')]"))).click();
        List<WebElement> serviceTypeCards = (List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='service-type-flex']")));
        for (WebElement element: serviceTypeCards){
            System.out.println(element.getText());
            Assert.assertEquals(element.getText(), "3D Capture");
        }
    }
}
