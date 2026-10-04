package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginSteps {

    LoginPage login=new LoginPage(DriverFactory.getDriver());

    ConfigReader config;



    @Given("User launches application")

    public void launchApplication() throws Exception {

        config=new ConfigReader();

        DriverFactory.getDriver().get(config.getProperty("url"));



    }

    @When("User enters username and password")

    public void login() throws Exception{

        config=new ConfigReader();

        login.enterUsername(config.getProperty("username"));

        login.enterPassword(config.getProperty("password"));

    }

    @When("Click Login")

    public void clickLogin(){

        login.clickLogin();

    }


}
