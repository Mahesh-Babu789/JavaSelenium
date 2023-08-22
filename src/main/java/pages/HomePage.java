package pages;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtils;

public class HomePage extends TestBase {

    TestUtils testUtils;
    OrdersPage ordersPage;

    @FindBy(xpath = "//a[contains(text(),'Today')]")
    WebElement todayDealsLink;

    @FindBy(css = "[placeholder='Search Amazon.in']")
    WebElement searchBox;

    @FindBy(css = ".nav-search-submit.nav-sprite")
    WebElement searchSubmit;

    @FindBy(css = "#nav-orders")
    WebElement ordersLink;

    public HomePage(){
        PageFactory.initElements(driver, this);
        testUtils = new TestUtils(driver);
        ordersPage = new OrdersPage();
    }

    public void searchItem(String productName){
        searchBox.sendKeys(productName);
        searchSubmit.click();
    }
    public DealsPage navigateToDealsPage(){
        todayDealsLink.click();
        return new DealsPage();
    }

    public OrdersPage navigateToOrdersPage(){
        ordersLink.click();
        return new OrdersPage();
    }
}
