package TestNG.LoghinTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.Login;

import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    String baseUrl = "https://simpalsid.com/user/login"; //https://simpalsid.com/user/register

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.gecko.driver", "D:\\projects\\TSAroEX\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }


    @Test
    public void LoginWithDefaultUserTest(){
        WebElement loginElement= driver.findElement(By.xpath("//div[@class=\"login__title\"]"));
        Assert.assertTrue(loginElement.isDisplayed());
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='login']"));
        usernameInput.sendKeys("ajax0070909");//use your username
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("qwe123!@#");//use your password
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        WebElement user = driver.findElement(By.xpath("//button[@class='user-button-dropdown']"));
        user.click();
        WebElement exit = driver.findElement(By.xpath("//button[@class='logout-button']"));
        exit.click();
    }

    // Page Object Model POM
    @Test
    public void LoginWithDefaultUserTest2(){
        Login login = new Login(driver);

        login.checkLoginElementPresence();
        login.usernameInputAnnotations.sendKeys("ajax0070909");
        login.completePassword("qwe123!@#");
        login.clickLoginBy();
    }
    @AfterMethod
    public void afterMethods(){
        driver.close();
        driver.quit();
    }
}
