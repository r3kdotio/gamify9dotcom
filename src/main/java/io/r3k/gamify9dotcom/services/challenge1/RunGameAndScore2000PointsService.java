package io.r3k.gamify9dotcom.services.challenge1;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import io.r3k.gamify9dotcom.services.challenge.AbstractChallenge;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/challenge1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RunGameAndScore2000PointsService extends AbstractChallenge {

  public RunGameAndScore2000PointsService() {
    super("challenge1.rungameandscore2000pointsservice");
  }

  @PostMapping(path = "/rungameandscore2000points")
  public ResponseEntity<ChallengeReponse> readInput(String givenString) {
    if (givenString.contains("Java version is: ")){
      if (!givenString.contains("Java version is: 9")){
        return failure("The game has started, but you are runnning with an old version of Java");
      }
      if (!givenString.contains("Scored point. Player now has 2000 points")){
        return failure("The game has started, but you have not scored 2000 points");
      }
      return success();
    } else {
      return failure("Output does not match the required input for the game");
    }
  }
}
