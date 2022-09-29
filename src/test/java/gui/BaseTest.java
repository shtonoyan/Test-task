package gui;

import gui.driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    @BeforeClass
    public void browserSetup() {
        Driver.initDriver();
    }

    @AfterClass
    public void browserTearDown() {
        Driver.quitDriver();
    }
}
