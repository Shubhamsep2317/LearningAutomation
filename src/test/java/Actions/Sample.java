package Actions;

import Automation.org.Shubham.WaitHelper.WaitHelpers;
import BoilerPlateCode.BoilerPlateCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.waitJVM;

public class Sample extends BoilerPlateCode {


        @Test
        public void test_actions_p4() {


            String URL = "https://www.makemytrip.com/";
            driver.get(URL);
            driver.manage().window().maximize();

            // Wait for the popup to come and click the x icon
            //span[@data-cy='closeModal']

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

            WaitHelpers.checkVisibility(driver, By.xpath("//span[@data-cy='closeModal']"));




            // This will close the modal
            WebElement model = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
            model.click();

            WebElement fromCity = driver.findElement(By.id("fromCity"));

            Actions actions = new Actions(driver);
            actions.moveToElement(fromCity).click().sendKeys("IXC").build().perform();

            waitJVM(3000);

            List<WebElement> list_autocomplete = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

            for (WebElement e: list_autocomplete){

                if(e.getText().contains("Chandigarh")){
                    e.click();
                }
            }



















        }


    }

