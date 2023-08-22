package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in");
        driver.findElement(By.cssSelector("#nav-link-accountList")).click();
        driver.findElement(By.cssSelector("#ap_email")).sendKeys("rajani.june@gmail.com");
        driver.findElement(By.cssSelector("#continue")).click();
        driver.findElement(By.cssSelector("#ap_password")).sendKeys("Hanuman@20");
        driver.findElement(By.id("signInSubmit")).click();

        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();

        driver.findElement(By.cssSelector("a[href='https://www.amazon.in/a/addresses?ref_=ya_d_c_addr']")).click();

        driver.findElement(By.cssSelector(".first-desktop-address-tile")).click();

        driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Mahesh");
        driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("9703233369");
        driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("500082");
        driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("flat 1");
        driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("Srinivas Nagar");
        driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys("Apollo");
        driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys("Apollo");
        driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();

        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();

        driver.findElement(By.cssSelector("[data-card-identifier='PaymentOptions']")).click();
        driver.findElement(By.cssSelector("[data-testid='cpe-mpo-Nav-BankAccount']")).click();
        driver.findElement(By.cssSelector("a[href='/gp/sva/new-account-details']")).click();
        driver.findElement(By.cssSelector("#newAccountDetailsForm label[for='IFSC_no']")).click();
        for (String s : "ICICI".split("")){
            driver.findElement(By.id("enterBankNameInput")).sendKeys(s);
        }
        driver.findElement(By.id("enterBankNameInput")).sendKeys("");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ac_results ul li"))).click();
        for (String c : "HYDERABAD".split("")) {
            driver.findElement(By.id("enterCityNameInput")).sendKeys(c);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.ac_even.ac_over"))).click();
        Select sel = new Select(driver.findElement(By.id("enterBranchNameInput")));
        sel.selectByVisibleText("JUBILEE HILLS, HYDERABAD");
        driver.findElement(By.id("addBankAccountHolderName")).sendKeys("Mahesh");
        driver.findElement(By.id("addBankAccountNumber")).sendKeys("012345678900");
        driver.findElement(By.id("confirmAddBankAccountNumber")).sendKeys("012345678900");
        Select accType = new Select(driver.findElement(By.id("addBankAccountType")));
        accType.selectByVisibleText("Savings");
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector(".a-span8 button[id='saveWithoutValidationButton']"))).doubleClick().build().perform();

        driver.quit();
    }
}
