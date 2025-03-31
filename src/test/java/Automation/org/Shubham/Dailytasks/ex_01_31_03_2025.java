package Automation.org.Shubham.Dailytasks;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Automation.org.Shubham.WaitHelper.WaitHelpers.checkVisibility;
import static Automation.org.Shubham.WaitHelper.WaitHelpers.waitJVM;

public class ex_01_31_03_2025 {

    private static final Logger log = LoggerFactory.getLogger(ex_01_31_03_2025.class);
    EdgeDriver edgeDriver;


    @BeforeTest
    public void login() {
        edgeDriver = new EdgeDriver();
        //edgeDriver.manage().window().maximize();
        String URL = "https://katalon-demo-cura.herokuapp.com/";
        edgeDriver.get(URL);
    }


    @Description("Book an appointment")
    @Test(priority = 1)
    public void katalon_demo_makeBooking(ITestContext iTestContext) {

//        WebElement makeAppointmentButton= edgeDriver.findElement(By.xpath("//a[@href='./profile.php#login']"));
//        makeAppointmentButton.click();

//        WebElement makeAppointmentButton=edgeDriver.findElement(By.id("btn-make-appointment"));
//        makeAppointmentButton.click();

//        checkVisibility(edgeDriver,By.xpath("//a[contains(text(),'Make Appointment')]"),3000);

        WebElement makeAppointmentButton = edgeDriver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]"));
        makeAppointmentButton.click();

        checkVisibility(edgeDriver, By.xpath("//input[@id='txt-username']"), 3000);

        WebElement login_username = edgeDriver.findElement(By.xpath("//input[@id='txt-username']"));
        login_username.sendKeys("John Doe");

        WebElement login_password = edgeDriver.findElement(By.xpath("//input[@id='txt-password']"));
        login_password.sendKeys("ThisIsNotAPassword");

        WebElement login_button = edgeDriver.findElement(By.xpath("//button[@id='btn-login']"));
        login_button.click();

//        String currentUrl=edgeDriver.getCurrentUrl();
//        Assert.assertEquals(currentUrl,"https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement selectTag = edgeDriver.findElement(By.xpath("//select[@id='combo_facility']"));

        Select select = new Select(selectTag);
        select.selectByContainsVisibleText("Hongkong");

        WebElement ApplyHospitalReadmission = edgeDriver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        ApplyHospitalReadmission.click();

        WebElement healthCareProgram = edgeDriver.findElement(By.xpath("//input[@id='radio_program_none']"));
        healthCareProgram.click();

        String date = "04/04/2025";
        WebElement insertDate = edgeDriver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        insertDate.sendKeys(date);

        iTestContext.setAttribute("Date", date);

        String comment = "Test Comment to check booking";
        WebElement insertComment = edgeDriver.findElement(By.xpath("//div/textarea[@id='txt_comment']"));
        insertComment.sendKeys(comment);

        iTestContext.setAttribute("Comment", comment);

        WebElement bookAppointment = edgeDriver.findElement(By.xpath("//div/button[@id='btn-book-appointment']"));
        bookAppointment.click();

        waitJVM(5000);


    }

    @Description("Verify Appointment Details")
    @Test(priority = 2)
    public void verifyAppointmentDetails(ITestContext iTestContext) {

        WebElement appointmentConfirmation = edgeDriver.findElement(By.xpath("//h2[contains(text(),'Appointment')]/following::p"));
        String confirmationText = appointmentConfirmation.getText();
        Assert.assertEquals(confirmationText, "Please be informed that your appointment has been booked as following:");

        WebElement facilityValue = edgeDriver.findElement((By.xpath("//label[contains(text(),'Facility')]/following::p[contains(text(),'Hongkong')]")));
        String FacilityValue = facilityValue.getText();
        Assert.assertEquals(FacilityValue, "Hongkong CURA Healthcare Center");

        WebElement visitDate = edgeDriver.findElement(By.xpath("//p[@id='visit_date']"));
        String bookingDate = visitDate.getText();
        Assert.assertEquals(bookingDate, iTestContext.getAttribute("Date"));

        WebElement CommentAdded = edgeDriver.findElement(By.xpath("//p[@id='comment']"));
        String Comments = CommentAdded.getText();
        Assert.assertEquals(Comments, iTestContext.getAttribute("Comment"));
    }

    @AfterTest
    public void logout() {

        WebElement hamburger = edgeDriver.findElement(By.xpath("//a[@id='menu-toggle']"));
        hamburger.click();

        checkVisibility(edgeDriver, By.xpath("//a[@href='authenticate.php?logout']"), 3000);

        WebElement logout = edgeDriver.findElement(By.xpath("//a[@href='authenticate.php?logout']"));
        logout.click();

        String currentURL = edgeDriver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://katalon-demo-cura.herokuapp.com/");
        edgeDriver.quit();
    }

}
