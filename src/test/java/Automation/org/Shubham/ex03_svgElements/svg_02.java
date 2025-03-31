package Automation.org.Shubham.ex03_svgElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.*;

public class svg_02 {

    //*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']

    @Test
    public void sampleSvgTest(){

        EdgeOptions edgeOptions=new EdgeOptions();
        //edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver=new EdgeDriver(edgeOptions);
        driver.get("https://www.amcharts.com/svg-maps/?map=india");
        driver.manage().window().maximize();

        checkVisibility(driver,By.xpath("//button[contains(text(),'I understand and agree')]"),3000);

        WebElement iAcceptPopUp=driver.findElement(By.xpath("//button[contains(text(),'I understand and agree')]"));
        iAcceptPopUp.click();

        waitJVM(3000);

        List <WebElement> states= driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));

        for(WebElement state:states){
            System.out.println(state.getDomAttribute("aria-label"));
            if(state.getDomAttribute("aria-label").contains("Himachal Pradesh")){
                state.click();
            }
        }
        driver.quit();
    }
}
