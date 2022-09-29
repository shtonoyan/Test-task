package api;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import lombok.experimental.UtilityClass;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

@UtilityClass
public class RequestUtils {

    public ValidatableResponse getRequest(String path) {
        return given()
                .when()
                .get(path)
                .then()
                .spec(getResponseSpecification())
                .log()
                .ifError();
    }

    private ResponseSpecification getResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(10L), TimeUnit.SECONDS)
                .build();
    }
}
