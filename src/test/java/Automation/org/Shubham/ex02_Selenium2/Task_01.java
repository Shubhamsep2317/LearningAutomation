package Automation.org.Shubham.ex02_Selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

import java.time.Duration;

public class Task_01 {

    @Test
    public void firstTestCase() {
        WebDriver driver = new EdgeDriver();
        String initialURL = "https://katalon-demo-cura.herokuapp.com/";

        driver.get(initialURL);

        WebElement makeAppointment = driver.findElement(By.id("btn-make-appointment"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> makeAppointment.isDisplayed());
        makeAppointment.click();

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.id("btn-login"));
        login.click();

        WebElement label = driver.findElement(By.xpath("//label[contains(text(),'Facility')]"));
        wait.until(d -> label.isDisplayed());

        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL).isNotEqualTo(initialURL);
        driver.quit();
    }


}
