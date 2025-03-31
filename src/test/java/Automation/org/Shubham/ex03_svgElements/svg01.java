package Automation.org.Shubham.ex03_svgElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.checkVisibility;
import static Automation.org.Shubham.WaitHelper.WaitHelpers.waitJVM;

public class svg01 {

    EdgeDriver edgeDriver;


    @BeforeTest
    public void setup() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get("https://www.flipkart.com/");
    }

    @Description("Verify the product name of first element via searching on flipkart")
    @Test
    public void testFlipkartFlow() {

        WebElement searchInput = edgeDriver.findElement(By.xpath("//input[@name='q']"));
        checkVisibility(edgeDriver, By.xpath("//input[@name='q']"), 3);
        searchInput.sendKeys("HP laptop Windows 11");

        List<WebElement> searchSVGIcon = edgeDriver.findElements(By.xpath("//*[local-name()='svg']"));
        searchSVGIcon.get(0).click();
        waitJVM(3);

        List<WebElement> searchIstResult = edgeDriver.findElements(By.xpath("//div[contains(text(),'HP')]"));
        String SearchTextResult = searchIstResult.get(0).getText();

        Assert.assertEquals(SearchTextResult, "HP 15s Intel Core i5 11th Gen 1155G7 - (16 GB/512 GB SSD/Windows 11 Home) 15s-fr4001TU Thin and Light ...");

    }


    @AfterTest
    public void exit_setup() {
        edgeDriver.quit();
    }


}
