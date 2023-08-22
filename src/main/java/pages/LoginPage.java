package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(id = "nav-link-accountList")
    WebElement signInLink;

    @FindBy(id = "signInSubmit")
    WebElement signInBtn;

    @FindBy(css = "#ap_email")
    WebElement email;

    @FindBy(css = "#ap_password")
    WebElement password;

    @FindBy(css = "#continue")
    WebElement continueBtn;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement loginTitle;

    @FindBy(css = "a[href='https://www.amazon.in/a/addresses?ref_=ya_d_c_addr']")
    WebElement addressLink;

    @FindBy(css = "[data-card-identifier='PaymentOptions']")
    WebElement paymentOptionsLink;

    public LoginPage(){
        PageFactory.initElements(driver, this);

    }

    public String singIn(String uname, String pwd){
        signInLink.click();
        email.sendKeys(uname);
        continueBtn.click();
        password.sendKeys(pwd);
        signInBtn.click();
        String title = loginTitle.getText();
        return title;
    }

    public WebElement getLoginTitle(){
        return loginTitle;
    }

    public AddressPage clickOnAddressLink() {
        addressLink.click();
        return new AddressPage();
    }

    public PaymentOptionsPage clickOnPaymentOptionsLink(){
        paymentOptionsLink.click();
        return new PaymentOptionsPage();
    }
}
