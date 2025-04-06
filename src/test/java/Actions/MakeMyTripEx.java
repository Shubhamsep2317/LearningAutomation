package Actions;

import BoilerPlateCode.BoilerPlateCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.*;

public class MakeMyTripEx extends BoilerPlateCode {

    @Test
    public void makeMyTripActionClassUsage() {

        String URL = "https://www.makemytrip.com/";
        driver.get(URL);

        checkVisibility(driver, By.xpath("//span[@data-cy='closeModal']"));

        WebElement closeModal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        closeModal.click();

        WebElement fromCity = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("IXC").build().perform();

        List<WebElement> cities = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        for (WebElement city : cities) {
            if (city.getText().contains("IXC")) {
                city.click();
            }
        }
    }
}
