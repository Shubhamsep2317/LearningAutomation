package Window_Handles;

import BoilerPlateCode.BoilerPlateCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class HandleWindows extends BoilerPlateCode {


    @Test
    public void test_windowHandle() {

        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);

        String parentHandle = driver.getWindowHandle();
        WebElement clickHereLink = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickHereLink.click();

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {

            if (!parentHandle.equals(handle)) {
                driver.switchTo().window(handle);
                Assert.assertTrue(driver.getPageSource().contains("New Window"));
                System.out.println("Test case is passed");
                driver.switchTo().window(parentHandle);
            }
        }
    }
}
