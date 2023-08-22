package TestCases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class WithLoginTests extends TestBase {

    LoginPage loginPage;
    AddressPage addressPage;
    PaymentOptionsPage paymentOptionsPage;
    HomePage homePage;
    OrdersPage ordersPage;
    String loggedInUserTitle;
  
    public WithLoginTests(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        addressPage = new AddressPage();
        paymentOptionsPage = new PaymentOptionsPage();
        homePage = new HomePage();
        ordersPage = new OrdersPage();
        loggedInUserTitle = loginPage.singIn(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void signInAndValidatePageTitle(){
        Assert.assertEquals(loggedInUserTitle, "Hello, Rajani");
    }

    @Test(priority = 2)
    public void addAddressAndValidate(){
        loginPage.getLoginTitle().click();
        loginPage.clickOnAddressLink();
        addressPage.addNewAddress();
        Assert.assertEquals(addressPage.getFlatNumber(), "Plot 1");
    }

    @Test(priority = 3)
    public void addNewPaymentOptionAndValidate() throws InterruptedException {
        loginPage.getLoginTitle().click();
        paymentOptionsPage = loginPage.clickOnPaymentOptionsLink();
        paymentOptionsPage.addNewPaymentOption();
        String accInfo = paymentOptionsPage.getNewPaymentOption();
        String successMsg = driver.findElement(By.xpath("//span[@class='a-size-large a-color-success']")).getText();
        Assert.assertEquals(successMsg, "Account Added");
        Assert.assertEquals(accInfo, "Account number: *****00");
    }

    @Test(priority = 4)
    public void verifyOrdersPageLabel(){
        ordersPage = homePage.navigateToOrdersPage();
        Assert.assertEquals(ordersPage.getOrderLabel(), "Your Orders");
    }

    @Test(priority = 5)
    public void getOrderDetailsAndValidate(){
        ordersPage = homePage.navigateToOrdersPage();
        String orderDetails = ordersPage.getLatestOrder().getText();
        String[] orderInfo= orderDetails.split(" ");
        String orderStatus = orderInfo[0];
        Assert.assertEquals(orderStatus, "Delivered");
        String orderDate = orderInfo[1];
        Assert.assertEquals(orderDate, "15-Jul-2023");
    }

    @Test(priority = 6)
    public void getLastYearOrderDetailsAndValidate(){
        ordersPage = homePage.navigateToOrdersPage();
        ordersPage.selectPreviousYear();
        String lastYearOrderDetails = ordersPage.getPreviousYearOrder();
        Assert.assertEquals(lastYearOrderDetails, "You last purchased this item on 19 Oct, 2022");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
