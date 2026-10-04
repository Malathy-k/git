package factory;


import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {

        driver.set(webDriver);

    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        getDriver().quit();

        driver.remove();
    }

}


