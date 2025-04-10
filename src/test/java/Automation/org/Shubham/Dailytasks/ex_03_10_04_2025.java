package Automation.org.Shubham.Dailytasks;

import BoilerPlateCode.BoilerPlateCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ex_03_10_04_2025 extends BoilerPlateCode {

    @Test
    public void WebAutomationChallenge() {
        String URL = "https://demoqa.com/webtables";
        driver.get(URL);
        driver.manage().window().maximize();

        // Get all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));

        for (int i = 1; i <= rows.size(); i++) {
            // Get first name from the current row
            WebElement firstNameCell = driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + i + "]//div[@class='rt-td'][1]"));
            String firstName = firstNameCell.getText();
            System.out.println("First Name: " + firstName);

            if (firstName.equalsIgnoreCase("Kierra")) {
                // Fetch the entire row's cells
                List<WebElement> cells = driver.findElements(By.xpath("//div[@class='rt-tr-group'][" + i + "]//div[@class='rt-td']"));

                // Print all cell values for Kierra
                for (WebElement cell : cells) {
                    System.out.println(cell.getText());
                }

                // Sample assertions (replace with your actual expected values)
                Assert.assertEquals(cells.get(0).getText(), "Kierra");         // First Name
                Assert.assertEquals(cells.get(1).getText(), "Gentry");         // Last Name
                Assert.assertEquals(cells.get(2).getText(), "29"); // Age
                Assert.assertEquals(cells.get(3).getText().trim(), "kierra@example.com");// Email
                Assert.assertEquals(cells.get(4).getText(), "2000");// Salary
                Assert.assertEquals(cells.get(5).getText(), "Legal");// Department

                break; // Exit loop after finding Kierra
            }
        }
    }
}
