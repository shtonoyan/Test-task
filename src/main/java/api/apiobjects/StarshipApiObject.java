package api.apiobjects;

import api.Paths;
import api.RequestUtils;
import api.ResponseUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class StarshipApiObject {
    public JsonPath getStarshipJPath(String id) {
        ValidatableResponse response = RequestUtils.getRequest(Paths.STARSHIPS + id);
        return ResponseUtils.getJsonPathFromResponse(response);
    }

    public String getStarshipClass(String id) {
        JsonPath starship = getStarshipJPath(id);
        return starship.getString("starship_class");
    }

    public JsonPath getStarshipsJPath() {
        ValidatableResponse response = RequestUtils.getRequest(Paths.STARSHIPS);
        return ResponseUtils.getJsonPathFromResponse(response);
    }

    public List<String> getStarshipPilotsByClass(String starshipClass) {
        JsonPath starshipsJPath = getStarshipsJPath();
        return starshipsJPath.getList("results.find{it.starship_class == '" + starshipClass + "'}.pilots");
    }
}
