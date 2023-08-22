package TestCases;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import util.TestUtils;

import java.time.Duration;

public class WithOutLoginTests extends TestBase {

    DealsPage dealsPage;
    HomePage homePage;
    OrdersPage ordersPage;
    TestUtils testUtils;
    String dealsPageTitle = "Amazon.in - Today's Deals";
    public WithOutLoginTests(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        dealsPage = new DealsPage();
        homePage = new HomePage();
        ordersPage = new OrdersPage();
        testUtils =new TestUtils(driver);
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }

    @Test(priority = 2)
    public void verifyTitle(){
        dealsPage = homePage.navigateToDealsPage();
        Assert.assertEquals(driver.getTitle(), dealsPageTitle);
    }

    @Test(priority = 3)
    public void addProductToCartAndValidate(){
        dealsPage = homePage.navigateToDealsPage();
        driver.findElement(By.xpath("//span[contains(text(),'Electronics')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[alt='High Performance Thin and Light Laptops']"))).click();
//        Thread.sleep(2000);
        dealsPage.getDealGridItem().click();
        dealsPage.getProduct().click();
        dealsPage.getAddToCartBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#attach-close_sideSheet-link"))).click();
//        Thread.sleep(2000);
        testUtils.clickOnCloseBtn();
//        Thread.sleep(1000);;
        String count = dealsPage.getCartCount();
        Assert.assertEquals(count, "1");
    }

    @Test(priority = 4)
    public void searchForMobilesAndPrintOutputInConsole(){
        dealsPage = homePage.navigateToDealsPage();
        homePage.searchItem("Mobiles");
        testUtils.scrollDown();
        String productDetails = dealsPage.getLastProductDetailsInTheList();
        System.out.println(productDetails);
        Assert.assertNotNull(productDetails);
    }

    @Test(priority = 5)
    public void navigateBackHomePageAfterSelectingMobiles(){
        driver.navigate().to("https://www.amazon.in/deals");
        Assert.assertEquals(driver.getTitle(), dealsPageTitle);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
