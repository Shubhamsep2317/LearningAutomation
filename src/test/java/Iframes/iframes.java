package Iframes;

import BoilerPlateCode.BoilerPlateCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.checkVisibility;
import static Automation.org.Shubham.WaitHelper.WaitHelpers.waitJVM;

public class iframes extends BoilerPlateCode {


       @Test
       public void miniProject(){

           String URL="https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1";
           driver.get(URL);

           driver.navigate().refresh();



           String getParentHandle= driver.getWindowHandle();


           List<WebElement> variationList= driver.findElements(By.xpath("//img[@data-qa='danawobuqa']"));

//           driver.switchTo().frame("vwo-survey-frame");
//           WebElement selectNo=driver.findElement(By.cssSelector("label[id='label-2']"));
//           selectNo.click();
//
//           WebElement Next=driver.findElement(By.xpath("//input[@value='Next']"));
//           Next.click();


           Actions action =new Actions(driver);
           action.moveToElement(variationList.get(1)).build().perform();


           waitJVM(5000);



           List<WebElement> HeatMap= driver.findElements(By.xpath("//div[contains(text(),'View Heatmap')]"));
           HeatMap.get(1).click();

           Set<String> allHandles=driver.getWindowHandles();

           for(String handle:allHandles){
               if(!getParentHandle.equals(handle)){
                   driver.switchTo().window(handle);
               }
           }

           waitJVM(15000);

           checkVisibility(driver,By.id("zenPopupModalClose"));

           WebElement closeModal=driver.findElement(By.id("zenPopupModalClose"));
           closeModal.click();

           driver.switchTo().frame("heatmap-iframe");

           WebElement clickMap=driver.findElement(By.cssSelector("div[data-qa='liqokuxuba']"));
           clickMap.click();

           //checkVisibility(driver,By.xpath(""));

        }


}
