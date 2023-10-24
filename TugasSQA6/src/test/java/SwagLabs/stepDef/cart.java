package SwagLabs.stepDef;

import SwagLabs.HelperClass;
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


public class cart {
//    HelperClass driverConfig = new HelperClass();
//    WebDriver driver = driverConfig.getDriver();

    WebDriver driver = HelperClass.getDriver();

    @Then("User on dashboard page")
    public void userOnDashboardPage(){
        String app = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(app,"Swag Labs");
    }
    @When("User add item")
    public void userAddItem(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    @Then("Cart badge change")
    public void cartBadgeChange() {
        String cartBadge = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cartBadge,"1");
    }
    @When("User click cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
    @And("User on cart page")
    public void userOnCartPage() {
        String cartTitle = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span")).getText();
        Assert.assertEquals(cartTitle,"Your Cart");
    }
    @And("Cart has item")
    public void cartHasItem() {
        String cartItem = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(cartItem,"Sauce Labs Backpack");
    }
    @Then("Remove item from cart")
    public void removeItemFromCart() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        driver.close();
    }
}
