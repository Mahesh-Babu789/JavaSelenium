package TestCases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.OrdersPage;

public class OrdersPageTest extends TestBase {

    LoginPage loginPage;
    OrdersPage ordersPage;
    HomePage homePage;

    public OrdersPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        ordersPage = new OrdersPage();
        homePage = new HomePage();
        loginPage.singIn(prop.getProperty("username"), prop.getProperty("password"));
        ordersPage = homePage.navigateToOrdersPage();
    }

    @Test(priority = 1)
    public void verifyOrdersPageLabel(){
        Assert.assertEquals(ordersPage.getOrderLabel(), "Your Orders");
    }

    @Test(priority = 2)
    public void getOrderDetailsAndValidate(){
        String orderDetails = ordersPage.getLatestOrder().getText();
        String[] orderInfo= orderDetails.split(" ");
        String orderStatus = orderInfo[0];
        Assert.assertEquals(orderStatus, "Delivered");
        String orderDate = orderInfo[1];
        Assert.assertEquals(orderDate, "15-Jul-2023");
    }

    @Test(priority = 3)
    public void getLastYearOrderDetailsAndValidate(){
        ordersPage.selectPreviousYear();
        String lastYearOrderDetails = ordersPage.getPreviousYearOrder();
        Assert.assertEquals(lastYearOrderDetails, "You last purchased this item on 19 Oct, 2022");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
