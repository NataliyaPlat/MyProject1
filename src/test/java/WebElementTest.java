import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebElementTest extends BaseTest1 {
    //dropdown menu
    @Test
    public void dropDownExample() {
        getDriver().get("http://demo.guru99.com/test/newtours/register.phh");
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='country']"))));
        //dropdown.selectByVisibleText("ARGENTINA");
        //dropdown.deselectAll();
        dropdown.selectByIndex(2);

        WebElement option = dropdown.getFirstSelectedOption();
        System.out.println(option.getText());
        List <WebElement> options = dropdown.getOptions();
        // List <WebElement> options = driver.findElements(By.cssSelector("select option"));
        for (int i = 0; i < options.size(); i++){
            System.out.println(options.get(i).getText());
        }
        // Thread.sleep(4000);
    }
    //checkbox and radiobuttons
    @Test
    public void checkBoxExample()
    {
        getDriver().get("http://demo.guru99.com/test/radio.html");
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vfb-6-1")));
        //driver.findElement(By.cssSelector("#vfb-6-1"));
        //driver.findElement(By.xpath("//*[@id='vfb-6-1']"));
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
    }
    @Test
    public void alertExample() {
        getDriver().get("http://demo.guru99.com/test/delete_customer.php");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='submit']"))).click();
        //driver.switchTo().alert().dismiss();
        System.out.println(getDriver().switchTo().alert().getText());
    }
}
