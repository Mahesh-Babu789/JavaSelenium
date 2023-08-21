package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DealsPage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),'Electronics')]")
    WebElement targetDeal;

    @FindBy(css = "[alt='High Performance Thin and Light Laptops']")
    WebElement dealGridItem;

    @FindBy(css = "#octopus-dlp-asin-stream li")
    WebElement product;

    @FindBy(css = "#add-to-cart-button")
    WebElement addToCartBtn;

    @FindBy(css = "#nav-cart-count")
    WebElement cartCount;

    @FindBy(css = "#nav-search-submit-button")
    WebElement searchBtn;

    @FindBy(xpath = "(//span[contains(text(),'Mobiles')])[2]")
    WebElement mobiles;


    public DealsPage(){
        PageFactory.initElements(driver, this);
    }

    public WebElement getDealGridItem(){
        return dealGridItem;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }
    public WebElement getProduct(){
        return product;
    }
    public String  getCartCount(){
        return cartCount.getText();
    }

    public String getLastProductDetailsInTheList(){
        List<WebElement> productList = driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));
        List<String> productInfo = productList.stream().map(e -> e.getText()).collect(Collectors.toList());
        Integer count = productInfo.size();
        return productInfo.get(count -1);
    }
}
