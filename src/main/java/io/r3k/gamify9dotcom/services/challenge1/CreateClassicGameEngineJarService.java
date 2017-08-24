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
public class CreateClassicGameEngineJarService extends AbstractChallenge{

  public CreateClassicGameEngineJarService() {
    super("challenge1.createclassicgameenginejarservice");
  }

  @PostMapping(path = "/createclassicgameenginejar")
  public ResponseEntity<ChallengeReponse> readJarDOutput(@RequestBody @NotNull String givenString) {
    if (givenString.contains("No module descriptor found. Derived automatic module")) {
      if (givenString.contains("contains com.gamify9.gameengine")) {
        return success();
      } else {
        return failure("Found derived automatic module, but it does not contain the correct packages");
      }
    }
    return failure("Output does not match the required input for jar -d --file=oldstylejars/gameengine-1.0.0.jar");
  }

}
