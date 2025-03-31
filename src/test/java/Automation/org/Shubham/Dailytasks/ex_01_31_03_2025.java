package Automation.org.Shubham.Dailytasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.checkVisibility;
import static Automation.org.Shubham.WaitHelper.WaitHelpers.waitJVM;

public class ex_01_31_03_2025 {


    @Test
    public void katalon_demo_makeBooking(){

        EdgeDriver edgeDriver=new EdgeDriver();
        edgeDriver.manage().window().maximize();
        String URL="https://katalon-demo-cura.herokuapp.com/";

        edgeDriver.get(URL);

//        WebElement makeAppointmentButton= edgeDriver.findElement(By.xpath("//a[@href='./profile.php#login']"));
//        makeAppointmentButton.click();

//        WebElement makeAppointmentButton=edgeDriver.findElement(By.id("btn-make-appointment"));
//        makeAppointmentButton.click();

//        checkVisibility(edgeDriver,By.xpath("//a[contains(text(),'Make Appointment')]"),3000);

        WebElement makeAppointmentButton=edgeDriver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]"));
        makeAppointmentButton.click();

        checkVisibility(edgeDriver,By.xpath("//input[@id='txt-username']"),3000);

        WebElement login_username=edgeDriver.findElement(By.xpath("//input[@id='txt-username']"));
        login_username.sendKeys("John Doe");

        WebElement login_password=edgeDriver.findElement(By.xpath("//input[@id='txt-password']"));
        login_password.sendKeys("ThisIsNotAPassword");

        WebElement login_button=edgeDriver.findElement(By.xpath("//button[@id='btn-login']"));
        login_button.click();

//        String currentUrl=edgeDriver.getCurrentUrl();
//        Assert.assertEquals(currentUrl,"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement selectTag= edgeDriver.findElement(By.xpath("//select[@id='combo_facility']"));

        Select select=new Select(selectTag);
        select.selectByContainsVisibleText("Hongkong");

        WebElement ApplyHospitalReadmission=edgeDriver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        ApplyHospitalReadmission.click();

        WebElement healthCareProgram=edgeDriver.findElement(By.xpath("//input[@id='radio_program_none']"));
        healthCareProgram.click();

        WebElement insertDate=edgeDriver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        insertDate.sendKeys("04/04/2025");

        WebElement insertComment=edgeDriver.findElement(By.xpath("//div/textarea[@id='txt_comment']"));
        insertComment.sendKeys("Test Comment to check booking");

        WebElement bookAppointment =edgeDriver.findElement(By.xpath("//div/button[@id='btn-book-appointment']"));
        bookAppointment.click();



        waitJVM(5000);

        edgeDriver.quit();













    }



}
