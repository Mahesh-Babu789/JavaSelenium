package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends TestBase {

    @FindBy(css = ".first-desktop-address-tile")
    WebElement addAddressLink;

    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    WebElement nameField;

    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    WebElement phoneNumber;

    @FindBy(id = "address-ui-widgets-enterAddressPostalCode")
    WebElement pinCode;

    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    WebElement flatNo;

    @FindBy(id = "address-ui-widgets-enterAddressLine2")
    WebElement streetNo;

    @FindBy(id = "address-ui-widgets-landmark")
    WebElement landMark;

    @FindBy(id = "address-ui-widgets-form-submit-button")
    WebElement addAddressBtn;

    @FindBy(xpath = "(//span[@id='address-ui-widgets-AddressLineOne'])[4]")
    WebElement validationAddress;

    public AddressPage(){
        PageFactory.initElements(driver, this);
    }
    public void addNewAddress(){
        addAddressLink.click();
        nameField.sendKeys("Mahesh");
        phoneNumber.sendKeys("9703233369");
        pinCode.sendKeys("500082");
        flatNo.sendKeys("Plot 1");
        streetNo.sendKeys("Sreenivas Nagar, Chintal");
        landMark.sendKeys("TKS GRAMMAR school");
        addAddressBtn.click();
    }

    public String getFlatNumber(){
        return validationAddress.getText();
    }
}
