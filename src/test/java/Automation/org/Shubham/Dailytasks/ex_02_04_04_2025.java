package Automation.org.Shubham.Dailytasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ex_02_04_04_2025 {
    String amountValues;
    Double positiveDoubleValues = 0.0;
    Double negativeDoubleValues = 0.0;

    @Test
    public void calculateMoneySpent() {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://demo.applitools.com/");

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Password@123");

        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signIn.click();


        String path = "//table[@class='table table-padded']//following-sibling::tbody/tr[";
        String path1 = "]/td[5]";

        int row = driver.findElements(By.xpath("//table[@class='table table-padded']//following-sibling::tbody/tr")).size();
        //int column=driver.findElements(By.xpath("//table[@class='table table-padded']//following-sibling::tbody/tr/td")).size();

        for (int i = 1; i <= row; i++) {
            String dynamic_path = path + i + path1;
            amountValues = driver.findElement(By.xpath(dynamic_path)).getText();

            amountValues = amountValues.replace("USD", "").replace(",", "").trim();

            if (amountValues.startsWith("+")) {
                positiveDoubleValues += Double.parseDouble(amountValues.replace("+", ""));
            } else if (amountValues.startsWith("-")) {
                negativeDoubleValues += Double.parseDouble(amountValues.replace("-", ""));
            }
        }
        System.out.println(positiveDoubleValues - negativeDoubleValues);
        driver.quit();
    }
}
