package api;

import gui.core.TestDataReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public abstract class BaseApiTest {
    @BeforeClass
    public void setBaseUri() {
        RestAssured.baseURI = TestDataReader.getProperty("BASE_URI");
    }
}
