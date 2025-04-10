package Iframes;

import BoilerPlateCode.BoilerPlateCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.waitJVM;

public class iframes extends BoilerPlateCode {


       @Test
       public void miniProject(){

           String URL="https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1";
           driver.get(URL);

           //driver.navigate().refresh();

           driver.manage().window().maximize();



           String getParentHandle= driver.getWindowHandle();

           //driver.switchTo().frame("vwo-survey-frame");

           waitJVM(10000);

//           checkVisibility(driver,By.cssSelector("svg[class='vwo-survey-close-icon']"),5);
//
//           WebElement closeIcon=driver.findElement(By.cssSelector("svg[class='vwo-survey-close-icon']"));
//           closeIcon.click();
//           WebElement selectNo=driver.findElement(By.cssSelector("label[id='label-2']"));
//           selectNo.click();
//
//           WebElement Next=driver.findElement(By.xpath("//input[@value='Next']"));
//           Next.click();


           List<WebElement> variationList= driver.findElements(By.xpath("//img[@data-qa='danawobuqa']"));

           Actions action =new Actions(driver);
           action.moveToElement(variationList.get(1)).build().perform();


           waitJVM(5000);



           List<WebElement> HeatMap= driver.findElements(By.xpath("//div[contains(text(),'View Heatmap')]"));
           HeatMap.get(1).click();

           Set<String> allHandles=driver.getWindowHandles();

           for(String handle:allHandles){
               if(!getParentHandle.equals(handle)){
                   driver.switchTo().window(handle);
                   driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='clickmap-image']//following::iframe[@id='heatmap-iframe']")));

                   WebElement clickMap=driver.findElement(By.cssSelector("div[data-qa='liqokuxuba']"));
                   clickMap.click();
               }
           }

//           driver.manage().window().maximize();
//           waitJVM(30000);


//           checkVisibility(driver,By.id("zenPopupModalClose"));
//
//           WebElement closeModal=driver.findElement(By.id("zenPopupModalClose"));
//           closeModal.click();

           //checkVisibility(driver,By.xpath("//div[@id='clickmap-image']//following::iframe[@id='heatmap-iframe']"));




           //checkVisibility(driver,By.xpath(""));

        }


}
