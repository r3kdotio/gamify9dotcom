package io.r3k.gamify9dotcom.services.challenge1;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import io.r3k.gamify9dotcom.services.challenge.AbstractChallenge;
import javax.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/challenge1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RunGameAndScoreService extends AbstractChallenge{

  public RunGameAndScoreService() {
    super("challenge1.rungameandscoreservice");
  }

  @PostMapping(path = "/rungameandscore")
  public ResponseEntity<ChallengeReponse> readInput(@RequestBody @NotNull String givenString) {
    if (givenString.contains("Java version is: ")){
      if (!givenString.contains("Java version is: 9")){
        return failure("The game has started, but you are runnning with an old version of Java");
      }
      if (!givenString.contains("Scored point. Player now has 1 point")){
        return failure("The game has started, but you have not scored a point");
      }
      return success();
    } else {
      return failure("Output does not match the required input for the game");
    }
  }
  
}
