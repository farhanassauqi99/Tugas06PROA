package SwagLabs.stepDef;

import SwagLabs.HelperClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkout {
    WebDriver driver = HelperClass.getDriver();

    @When("Click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }
    @Then("Input (.*) as firstname$")
    public void inputFirstName(String firstname){
        driver.findElement(By.id("first-name")).sendKeys(firstname);
    }
    @And("Input (.*) as lastname$")
    public void inputLastnameAsLastname(String lastname) {
        driver.findElement(By.id("last-name")).sendKeys(lastname);
    }

    @And("Input (.*) as postal$")
    public void inputZipcodeAsZipcode(String postal) {
        driver.findElement(By.id("postal-code")).sendKeys(postal);
    }

    @And("Click continue button")
    public void clickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("User on checkout overview page")
    public void userOnCheckoutOverviewPage() {
        String pageTitle = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText();
        Assert.assertEquals(pageTitle,"Checkout: Overview");
    }

    @When("Click finish button")
    public void clickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("User on checkout complete page")
    public void userOnCheckoutCompletePage() {
        String pageTitle = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText();
        Assert.assertEquals(pageTitle,"Checkout: Complete!");
        driver.close();
    }
}
