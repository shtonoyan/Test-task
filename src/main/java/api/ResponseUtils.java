package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseUtils {
    public JsonPath getJsonPathFromResponse(ValidatableResponse response) {
        return response
                .extract()
                .jsonPath();
    }
}
