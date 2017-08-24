package io.r3k.gamify9dotcom.services.challenge1;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RunGameAndScore2000PointsServiceTest {

  @Test
  public void shouldRespondWithSuccessFor2000PointsAndGameStartedIndicators() {
    //given
    String givenString = "Java version is: 9\n"
            + "-> support for BufferedImage\n"
            + "Version helper for 1.2+ initialized!\n"
            + "-> using BufferedImage\n"
            + "Software renderer (OpenGL mode) initialized\n"
            + "Software renderer disposed\n"
            + "Software renderer (OpenGL mode) initialized\n"
            + "Adding Lightsource: 0\n"
            + "Worker created using 7 queues!\n"
            + "New WorldProcessor created using 1 thread(s) and granularity of 1!\n"
            + "Creating new world processor buffer for thread main\n"
            + "Software renderer disposed\n"
            + "Scored point. Player now has 2000 points";
    //when
    RunGameAndScore2000PointsService underTest = new RunGameAndScore2000PointsService();
    ResponseEntity<ChallengeReponse> response = underTest.readInput(givenString);
    //then
    assertNull(response.getBody().getMessage());
    assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

  }

  public void shouldRespondWithFailureBecauseAnOldVersionOfJavaIsUsed() {
    //given
    String givenString = "Java version is: 8\n"
            + "-> support for BufferedImage\n"
            + "Version helper for 1.2+ initialized!\n"
            + "-> using BufferedImage\n"
            + "Software renderer (OpenGL mode) initialized\n"
            + "Software renderer disposed\n"
            + "Software renderer (OpenGL mode) initialized\n"
            + "Adding Lightsource: 0\n"
            + "Worker created using 7 queues!\n"
            + "New WorldProcessor created using 1 thread(s) and granularity of 1!\n"
            + "Creating new world processor buffer for thread main\n"
            + "Software renderer disposed\n"
            + "Scored point. Player now has 2000 points";
    //when
    RunGameAndScore2000PointsService underTest = new RunGameAndScore2000PointsService();
    ResponseEntity<ChallengeReponse> response = underTest.readInput(givenString);
    //then
    assertEquals("The game has started, but you are runnning with an old version of Java", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void shouldRespondWithErrorIfNoPointIsScored() {
    //given
    String givenString = "Java version is: 9\n"
            + "-> support for BufferedImage\n"
            + "Version helper for 1.2+ initialized!\n"
            + "-> using BufferedImage\n"
            + "Software renderer (OpenGL mode) initialized\n"
            + "Software renderer disposed\n"
            + "Software renderer (OpenGL mode) initialized\n"
            + "Adding Lightsource: 0\n"
            + "Worker created using 7 queues!\n"
            + "New WorldProcessor created using 1 thread(s) and granularity of 1!\n"
            + "Creating new world processor buffer for thread main\n"
            + "Software renderer disposed\n";
    //when
    RunGameAndScore2000PointsService underTest = new RunGameAndScore2000PointsService();
    ResponseEntity<ChallengeReponse> response = underTest.readInput(givenString);
    //then
    assertEquals("The game has started, but you have not scored 2000 points", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void shouldRespondWithErrorIfInputIsEmpty() {
    //given
    String givenString = "";
    //when
    RunGameAndScore2000PointsService underTest = new RunGameAndScore2000PointsService();
    ResponseEntity<ChallengeReponse> response = underTest.readInput(givenString);
    //then
    assertEquals("Output does not match the required input for the game", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

}
