package TestCases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PaymentOptionsPage;

public class PaymentOptionsPageTest extends TestBase {

    PaymentOptionsPage paymentOptionsPage;
    LoginPage loginPage;

    public PaymentOptionsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        paymentOptionsPage = new PaymentOptionsPage();
        loginPage = new LoginPage();
        loginPage.singIn(prop.getProperty("username"), prop.getProperty("password"));
        loginPage.getLoginTitle().click();
        paymentOptionsPage = loginPage.clickOnPaymentOptionsLink();
    }

    @Test
    public void addNewPaymentOptionAndValidate() throws InterruptedException {
        paymentOptionsPage.addNewPaymentOption();
        String accInfo = paymentOptionsPage.getNewPaymentOption();
        String successMsg = driver.findElement(By.xpath("//span[@class='a-size-large a-color-success']")).getText();
        Assert.assertEquals(successMsg, "Account Added");
        Assert.assertEquals(accInfo, "Account number: *****00");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
