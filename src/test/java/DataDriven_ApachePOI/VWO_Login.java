package DataDriven_ApachePOI;

import BoilerPlateCode.BoilerPlateCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.checkVisibility;

public class VWO_Login extends BoilerPlateCode {

    @Test(dataProvider = "getData")
    public void vwo_login(String username, String password) {

        String URL = "https://app.vwo.com/#/login";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement inputUsername = driver.findElement(By.cssSelector("input[data-qa='hocewoqisi']"));
        inputUsername.clear();
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.cssSelector("input[data-qa='jobodapuxe']"));
        inputPassword.clear();
        inputPassword.sendKeys(password);

        WebElement signIn = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        signIn.click();

        checkVisibility(driver, By.xpath("//div[@id='js-notification-box']"));
        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='js-notification-box']"));
        String errorMessageText = errorMessage.getText();

        Assert.assertEquals(errorMessageText, "Your email, password, IP address or location did not match");

    }

    @DataProvider
    public Object[][] getData() {
        return UtilExcelVWOLogin.getExcelSheetData("sheet1");
    }
}
