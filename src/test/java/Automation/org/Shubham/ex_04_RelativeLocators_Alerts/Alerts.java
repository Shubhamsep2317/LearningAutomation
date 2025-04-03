package Automation.org.Shubham.ex_04_RelativeLocators_Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.checkVisibility;
import static Automation.org.Shubham.WaitHelper.WaitHelpers.waitJVM;

public class Alerts {

    @Test
    public void alerts() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");

        String url = "https://the-internet.herokuapp.com/javascript_alerts";
        EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
        edgeDriver.get(url);

        WebElement alertAccept = edgeDriver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertAccept.click();
        // Other xpath=//button[contains(text(),'Alert')]

        Alert alert1 = edgeDriver.switchTo().alert();
        alert1.accept();

        WebElement Result= edgeDriver.findElement(By.cssSelector("p[id='result']"));
        String ActualResult= Result.getText();
        Assert.assertEquals(ActualResult,"You successfully clicked an alert");

        waitJVM(5000);

        WebElement alertDismiss = edgeDriver.findElement(RelativeLocator.with(By.xpath("//button[@onclick='jsConfirm()']")).below(alertAccept));
        alertDismiss.click();

        Alert alert2=edgeDriver.switchTo().alert();
        alert2.dismiss();
        String ActualResult2= Result.getText();
        Assert.assertEquals(ActualResult2,"You clicked: Cancel");

        checkVisibility(edgeDriver,RelativeLocator.with(By.xpath("//button[@onclick='jsPrompt()']")).below(alertDismiss));
        WebElement alertSendKeys=edgeDriver.findElement(RelativeLocator.with(By.xpath("//button[@onclick='jsPrompt()']")).below(alertDismiss));
        alertSendKeys.click();

        Alert alert3=edgeDriver.switchTo().alert();
        alert3.sendKeys("Shubham");
        alert3.accept();

        String ActualResult3= Result.getText();
        Assert.assertEquals(ActualResult3,"You entered: Shubham");





    }
}
