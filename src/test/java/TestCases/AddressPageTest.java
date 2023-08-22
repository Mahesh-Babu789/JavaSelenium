package TestCases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddressPage;
import pages.LoginPage;

public class AddressPageTest extends TestBase {

    AddressPage addressPage;
    LoginPage loginPage;
    public AddressPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        addressPage = new AddressPage();
        loginPage = new LoginPage();
        loginPage.singIn(prop.getProperty("username"), prop.getProperty("password"));
        loginPage.getLoginTitle().click();
        loginPage.clickOnAddressLink();
    }
    @Test
    public void addAddressAndValidate(){
        addressPage.addNewAddress();
        Assert.assertEquals(addressPage.getFlatNumber(), "Plot 1");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
