package stepDefinitions;

import Pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStepsPOM {
    WebDriver driver = null;

    @Given("browser is open on page")
    public void browser_is_open_on_page() {
            System.out.println(">>>>>>>>>>step browser is open");

            String projectPath = System.getProperty("user.dir");
            System.out.println("Project path is " + projectPath);

            System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

//        driver.manage().window().maximize();
    }

    @And("user is on login page")
    public void user_is_on_login_page() {

        driver.navigate().to("https://www.saucedemo.com/");
    }

    @When("^user enters (.*) and (.*)$") //using parameter with scenario outline on feature
    public void user_enters_username_and_password(String username, String password) throws InterruptedException {

        loginPage login = new loginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);

//        driver.findElement(By.id("user-name")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
    }

    @And("user clicks on login")
    public void user_clicks_on_login() throws InterruptedException {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        driver.getPageSource().contains("Sauce Labs Backpack");
        driver.findElement(By.id("inventory_container")).isDisplayed();
        driver.close();
        driver.quit();
    }
}