package Actions;

import BoilerPlateCode.BoilerPlateCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class ActionsClass extends BoilerPlateCode {

    // For handling mouse and keyboard events we use Actions Class
    @Test
    public void action() {
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        WebElement lastName = driver.findElement(RelativeLocator.with(By.cssSelector("input[name='lastname']")).below(firstName));

        Actions action = new Actions(driver);

        action.keyDown(Keys.SHIFT)
                .sendKeys(firstName, "shubham")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.TAB)
                .keyDown(Keys.SHIFT)
                .sendKeys(lastName, "sharma")
                .build().perform();
    }
}
