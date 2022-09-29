package api.apiobjects;

import api.Paths;
import api.RequestUtils;
import api.ResponseUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class FilmApiObject {
    public JsonPath getFilmsJPath() {
        ValidatableResponse response = RequestUtils.getRequest(Paths.FILMS);
        return ResponseUtils.getJsonPathFromResponse(response);
    }

    public List<String> getFilmCharactersList(String film) {
        JsonPath filmsJPath = getFilmsJPath();
        return filmsJPath.getList("results.find{it.title == '" + film + "'}.characters");
    }
}
