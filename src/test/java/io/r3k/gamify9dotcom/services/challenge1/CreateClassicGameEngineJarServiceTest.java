package io.r3k.gamify9dotcom.services.challenge1;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CreateClassicGameEngineJarServiceTest {

  @Test
  public void shouldRespondWithSuccessForValidReadJarDOutput() {
    //given
    String givenString = "No module descriptor found. Derived automatic module.\n"
            + "\n"
            + "gameengine@1.0.0 automatic\n"
            + "requires java.base mandated\n"
            + "contains com.gamify9.gameengine\n"
            + "contains com.gamify9.gameengine.score";
    //when
    CreateClassicGameEngineJarService underTest = new CreateClassicGameEngineJarService();
    ResponseEntity<ChallengeReponse> response = underTest.readJarDOutput(givenString);
    //then
    assertNull(response.getBody().getMessage());
    assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
  }

  @Test
  public void shouldRespondWithFailureWhenItIsAModuleButNotTheCorrectModule() {
    //given
    String givenString = "No module descriptor found. Derived automatic module.\n"
            + "\n"
            + "mygame@1.0.0 automatic\n"
            + "requires java.base mandated\n"
            + "contains com.gamify9.mygame";
    //when
    CreateClassicGameEngineJarService underTest = new CreateClassicGameEngineJarService();
    ResponseEntity<ChallengeReponse> response = underTest.readJarDOutput(givenString);
    //then
    assertEquals("Found derived automatic module, but it does not contain the correct packages", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }
  @Test
  public void shouldRespondWithFailureWhenWhenInputIsEmpty() {
    //given
    String givenString = "";
    //when
    CreateClassicGameEngineJarService underTest = new CreateClassicGameEngineJarService();
    ResponseEntity<ChallengeReponse> response = underTest.readJarDOutput(givenString);
    //then
    assertEquals("Output does not match the required input for jar -d --file=oldstylejars/gameengine-1.0.0.jar", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }
}
