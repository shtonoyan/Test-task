package api.apiobjects;

import api.Paths;
import api.RequestUtils;
import api.ResponseUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PeopleApiObject{
    public JsonPath getPeopleJPath() {
        ValidatableResponse response = RequestUtils.getRequest(Paths.PEOPLE);
        return ResponseUtils.getJsonPathFromResponse(response);
    }

    public String getPersonByName(String name) {
        JsonPath peopleJPath = getPeopleJPath();
        return peopleJPath.getString("results.find{it.name == '" + name + "'}.url");
    }

    public List<String> getPersonStarships(String name) {
        JsonPath peopleJPath = getPeopleJPath();
        return peopleJPath.getList("results.find{it.name == '" + name + "'}.starships");
    }

    public List<String> getPersonStarshipIds(String name) {
        List<String> starships = getPersonStarships(name);
        return starships.stream().map(starship -> starship.split("starships")[1]).collect(Collectors.toList());
    }
}
