package TestCases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DealsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrdersPage;

public class HomePageTest extends TestBase {

    HomePage homePage;
    DealsPage dealsPage;
    OrdersPage ordersPage;
    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        dealsPage = new DealsPage();
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }

    @Test(priority = 2)
    public void navigateToDealsPageTest() {
        dealsPage = homePage.navigateToDealsPage();
    }

    @Test(priority = 3)
    public void clickOnOrdersLink(){
        ordersPage = homePage.navigateToOrdersPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
