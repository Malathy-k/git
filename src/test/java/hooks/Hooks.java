package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

import java.io.IOException;
import java.util.Base64;
import java.util.logging.Logger;

public class Hooks {

    private static ExtentReports extent =
            ExtentManager.getExtentReport();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    private int stepCounter = 1;

    Logger log = Logger.getLogger(Hooks.class.getName());
    @Before

    public void beforeScenario(Scenario scenario){
        log.info("===================================");

        log.info("Scenario Started : "
                + scenario.getName());
        WebDriver driver = new ChromeDriver();
        DriverFactory.setDriver(driver);
        DriverFactory.getDriver().manage().window().maximize();
        test.set(extent.createTest(scenario.getName()));

        stepCounter = 1;



    }

    @AfterStep
    public void afterEachStep(Scenario scenario) {

        try {
            byte[] screenshot =
                    ScreenshotUtil. getScreenshot (
                            DriverFactory.getDriver());

            String encodeToString = Base64.getEncoder().encodeToString(screenshot);
            test.get().info("Step "+stepCounter,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(encodeToString).build());


            stepCounter++;

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }


    @After

    public void afterScenario(Scenario scenario){

        if(scenario.isFailed()){

            log.info("Scenario Failed");

        }

        else{

            log.info("Scenario Passed");

        }

        DriverFactory.quitDriver();
        log.info("Browser Closed");
        extent.flush();

    }

}
