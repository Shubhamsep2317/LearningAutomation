package Automation.org.Shubham.ex01_Selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumBasic {

    @Test
    public void test_verifyvwologin(){

        FirefoxDriver driver= new FirefoxDriver();
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
