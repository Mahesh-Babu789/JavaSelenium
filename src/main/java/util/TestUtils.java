package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestUtils {

    WebDriver driver;

    @FindBy(css = "#attach-close_sideSheet-link")
    WebElement closeBtn;

    public TestUtils(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public void clickOnCloseBtn(){
        closeBtn.click();
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0, 5000)");
    }
}
