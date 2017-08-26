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
public class CreateClassicMyGameJarService extends AbstractChallenge {

  public CreateClassicMyGameJarService() {
    super("challenge1.createclassicmygamejarservice");
  }

  @PostMapping(path = "/createclassicmygamejar")
  public ResponseEntity<ChallengeReponse> readJarDOutput(@RequestBody @NotNull String givenString) {
    if (givenString.contains("Derived automatic module")) {
      if (givenString.contains("contains com.gamify9.mygame")) {
        return success();
      } else {
        return failure("Found derived automatic module, but it does not contain the correct packages com.gamify9.mygame");
      }
    }
    return failure("Output does not match the required input for jar -d --file=oldstylejars/mygame-1.0.0.jar");
  }

}
