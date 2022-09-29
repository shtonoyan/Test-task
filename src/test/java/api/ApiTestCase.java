package api;

import api.apiobjects.FilmApiObject;
import api.apiobjects.PeopleApiObject;
import api.apiobjects.StarshipApiObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ApiTestCase extends BaseApiTest {
    @Test
    public void apiUseCase() {
        String characterName = "Biggs Darklighter";
        String starshipClass = "Starfighter";

        final List<String> charactersList = FilmApiObject.getFilmCharactersList("A New Hope");

        final String character = PeopleApiObject.getPersonByName(characterName);

        Assert.assertTrue(charactersList.contains(character), "The character is not in the film characters list...");

        final List<String> characterStarshipIds = PeopleApiObject.getPersonStarshipIds(characterName);
        final List<String> starshipClasses = characterStarshipIds
                .stream()
                .map(StarshipApiObject::getStarshipClass)
                .collect(Collectors.toList());

        Assert.assertTrue(starshipClasses.contains(starshipClass), starshipClass + "in not in the starship classes list...");

        final List<String> pilotsOfStarship = StarshipApiObject.getStarshipPilotsByClass(starshipClass);
        final String pilot = PeopleApiObject.getPersonByName("Luke Skywalke");

        Assert.assertTrue(pilotsOfStarship.contains(pilot), "This Pilot is not among the starships' pilots...");
    }
}
