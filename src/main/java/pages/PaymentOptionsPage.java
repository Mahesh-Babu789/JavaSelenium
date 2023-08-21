package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentOptionsPage extends TestBase {

    @FindBy(css = "[data-testid='cpe-mpo-Nav-BankAccount']")
    WebElement manageBankAccountsLink;

    @FindBy(css = "a[href='/gp/sva/new-account-details']")
    WebElement addNewBankAccount;

    @FindBy(css = "#newAccountDetailsForm label[for='IFSC_no']")
    WebElement ifscCode;

    @FindBy(id = "enterBankNameInput")
    WebElement bankName;

    @FindBy(id = "enterCityNameInput")
    WebElement cityName;

    @FindBy(id = "addBankAccountHolderName")
    WebElement accountHolderName;

    @FindBy(id = "addBankAccountNumber")
    WebElement accountNumber;

    @FindBy(id = "confirmAddBankAccountNumber")
    WebElement confirmBankAccountNumber;

    @FindBy(xpath = "(//*[@class='a-ordered-list a-vertical']/li)[1]//span[contains(text(),'Account number: *****00')]")
    WebElement bankAccountInfo;

    public PaymentOptionsPage(){
        PageFactory.initElements(driver, this);
    }

    public void addNewPaymentOption() throws InterruptedException {
        manageBankAccountsLink.click();
        addNewBankAccount.click();
        ifscCode.click();
        for (String s : "ICICI".split("")){
            bankName.sendKeys(s);
        }
        bankName.sendKeys(" ");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ac_results ul li"))).click();
        for (String c : "HYDERABAD".split("")) {
            cityName.sendKeys(c);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.ac_even.ac_over"))).click();
        Select sel = new Select(driver.findElement(By.id("enterBranchNameInput")));
        sel.selectByVisibleText("JUBILEE HILLS, HYDERABAD");
        accountHolderName.sendKeys("Mahesh");
        accountNumber.sendKeys("012345678900");
        confirmBankAccountNumber.sendKeys("012345678900");
        Select accType = new Select(driver.findElement(By.id("addBankAccountType")));
        accType.selectByVisibleText("Savings");
        Thread.sleep(1000);
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector(".a-span8 button[id='saveWithoutValidationButton']"))).doubleClick().build().perform();
    }

    public String getNewPaymentOption(){
        String accInfo = bankAccountInfo.getText();
        return accInfo;
    }

}
