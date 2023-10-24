package SwagLabs.stepDef;

import SwagLabs.HelperClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class login {
//    WebDriver driver;
//    String baseUrl = "https://www.saucedemo.com/";

    HelperClass driverConfig = new HelperClass();
    WebDriver driver = driverConfig.getDriver();

    @Given("Login Page")
    public void login_page(){
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.get(baseUrl);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

        //Assertion
        String loginPageAssert = driver.findElement(By.className("login_logo")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("Input (.*) as username$")
    public void inputUsernameAsUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }
    @And("Input (.*) as password$")
    public void inputPasswordAsPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @Then("I verify (.*) login result$")
    public void iVerifyStatusLoginResult(String status) {
        if(status.equals("success")){
            String app = driver.findElement(By.className("app_logo")).getText();
            Assert.assertEquals(app,"Swag Labs");
        }else if(status.equals("locked")) {
            String errorLogin = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
            Assert.assertEquals(errorLogin,"Epic sadface: Sorry, this user has been locked out.");
        }else {
            String errorLogin = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
            Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");
        }
        driver.close();
    }


    @When("Input registered username")
    public void inputUsername(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @And("Input invalid password")
    public void inputInvalidPassword(){
        driver.findElement(By.id("password")).sendKeys("12345");
    }
    @And("Click login button")
    public void clickLoginButton(){
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User get error message")
    public void UserGetErrorMessage(){
        String errorLogin = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @And("Input registered password")
    public void inputPassword(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
}
