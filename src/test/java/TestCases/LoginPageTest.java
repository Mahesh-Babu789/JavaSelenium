package TestCases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }
    @Test(priority = 1)
    public void signIn(){
        String loggedInUserTitle = loginPage.singIn(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(loggedInUserTitle, "Hello, Rajani");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
