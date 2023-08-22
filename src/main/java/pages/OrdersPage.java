package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage extends TestBase {


    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-bold'])[1]")
    WebElement orderDetails;

    @FindBy(css = "[href='/gp/product/B077TNHLW8/ref=ppx_yo_dt_b_asin_title_o00_s00?ie=UTF8&psc=1']")
    WebElement productLink;

    @FindBy(xpath = "((//*[@class='a-fixed-left-grid'])[1]//span)[1]")
    WebElement previousYearOrder;

    @FindBy(xpath = "//h1[contains(text(),'Your Orders')]")
    WebElement orderLabel;

    public OrdersPage(){
        PageFactory.initElements(driver, this);
    }

    public String getOrderLabel(){
        String ordersPageLabel = orderLabel.getText();
        return ordersPageLabel;
    }

    public void selectPreviousYear(){
        Select sel = new Select(driver.findElement(By.id("time-filter")));
        sel.selectByVisibleText("2022");
    }

    public String getPreviousYearOrder(){
        productLink.click();
        String orderInfo = previousYearOrder.getText();
        return orderInfo;
    }

    public WebElement getLatestOrder(){
        return orderDetails;
    }
}
