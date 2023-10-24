package SwagLabs.stepDef;

import SwagLabs.HelperClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class resetState {

    WebDriver driver = HelperClass.getDriver();

    @When("User click burger menu icon")
    public void userClickBurgerMenuIcon() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User click reset app state")
    public void userClickResetAppState() {
        driver.findElement(By.id("reset_sidebar_link")).click();
    }

    @Then("Cart badge reset")
    public void cartBadgeReset() {
        String cartIcon = driver.findElement(By.className("shopping_cart_link")).getText();
        Assert.assertEquals(cartIcon,"");
        driver.close();
    }
}
