package TestCases;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DealsPage;
import pages.HomePage;
import util.TestUtils;

public class DealsPageTest extends TestBase {

    DealsPage dealsPage;
    HomePage homePage;
    TestUtils testUtils;

    String dealsPageTitle = "Amazon.in - Today's Deals";
    public DealsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        dealsPage = new DealsPage();
        homePage = new HomePage();
        testUtils = new TestUtils(driver);
        dealsPage = homePage.navigateToDealsPage();
    }

    @Test(priority = 1)
    public void verifyTitle(){
        String dealsPageTitle = "Amazon.in - Today's Deals";
        Assert.assertEquals(driver.getTitle(), dealsPageTitle);
    }

    @Test(priority = 2)
    public void addProductToCartAndValidate() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Electronics')]")).click();
        Thread.sleep(2000);
        dealsPage.getDealGridItem().click();
        dealsPage.getProduct().click();
        dealsPage.getAddToCartBtn().click();
        Thread.sleep(2000);
        testUtils.clickOnCloseBtn();
        Thread.sleep(1000);;
        String count = dealsPage.getCartCount();
        Assert.assertEquals(count, "1");
    }

    @Test(priority = 3)
    public void searchForMobilesAndPrintOutputInConsole(){
        dealsPage = homePage.navigateToDealsPage();
        homePage.searchItem("mobiles");
        testUtils.scrollDown();
        String productDetails = dealsPage.getLastProductDetailsInTheList();
        System.out.println(productDetails);
        Assert.assertNotNull(productDetails);
    }

    @Test(priority = 4)
    public void navigateBackHomePageAfterSelectingMobiles(){
        driver.navigate().to("https://www.amazon.in/deals");
        Assert.assertEquals(driver.getTitle(), dealsPageTitle);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
