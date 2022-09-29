package gui.driver;

import gui.core.Logger;
import gui.core.TestDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static final String BROWSER_SIZE = TestDataReader.getProperty("BROWSER_SIZE");
    private static WebDriver singletonDriver = null;

    private Driver() {
    }

    public static void initDriver() {
        if (singletonDriver == null) {
            WebDriverManager.chromedriver().setup();
            singletonDriver = new ChromeDriver();

        }
        switch (BROWSER_SIZE) {
            case "1024x768":
                Dimension dimension = new Dimension(1024, 768);
                singletonDriver.manage().window().setSize(dimension);
                break;
            case "800x600":
                Dimension dimension1 = new Dimension(800, 600);
                singletonDriver.manage().window().setSize(dimension1);
                break;
            default:
                singletonDriver.manage().window().maximize();
                break;
        }
    }

    public static WebDriver getSingletonDriver() {
        return singletonDriver;
    }


    public static void quitDriver() {
        Logger.log("The driver is quitting");
        singletonDriver.quit();
        singletonDriver = null;
    }
}
